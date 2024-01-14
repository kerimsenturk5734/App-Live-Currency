package com.example.applivecurrency.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applivecurrency.data.api.APICurrencyService.apiService
import com.example.applivecurrency.data.api.payload.APICurrencyToAllResponse
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.domain.CurrencyMapper
import com.example.applivecurrency.domain.model.Currency
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APICurrencyViewModel(context: Context) : ViewModel() {
    private val currencyViewModel = InstanceProvider.provideCurrencyViewModel(context)

    private val _currencyData = MutableLiveData<List<Currency>>()
    val currencyData: LiveData<List<Currency>> get() = _currencyData

    private val _statusCode = MutableLiveData<Int>()
    val statusCode: LiveData<Int> get() = _statusCode

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing : StateFlow<Boolean> get() = _isRefreshing

    fun fetchCurrencyToAll(baseCurrency: String, quantity: Int) {
        viewModelScope.launch {
            _isLoading.update { true }

            apiService.callCurrencyToAll(baseCurrency, quantity).enqueue(object : Callback<APICurrencyToAllResponse> {
                override fun onResponse(call: Call<APICurrencyToAllResponse>, response: Response<APICurrencyToAllResponse>) {

                    if (response.isSuccessful) {
                        Log.d("API Data Success", response.code().toString())
                        _currencyData.value = response.body()
                            ?.let { CurrencyMapper().apiCurrenciesToCurrencies(it.result.data) }

                        response.body()
                            ?.let { CurrencyMapper().apiCurrenciesToCurrencies(it.result.data) }
                            ?.let { currencyViewModel.upsertCurrenciesFields(it) }
                    } else {
                        Log.d("API Data Failed", response.message()+response.code())
                    }

                    _statusCode.value = response.code()
                    _isLoading.update { false }
                }

                override fun onFailure(call: Call<APICurrencyToAllResponse>, t: Throwable) {
                    _statusCode.value = 404
                    Log.d("API Error", _statusCode.value.toString())

                    _isLoading.update { false }
                }
            })
        }
    }
    fun refresh(){
        viewModelScope.launch{
            _isRefreshing.emit(true)
            fetchCurrencyToAll("TRY", 1)
            _isRefreshing.emit(false)
            Log.d("Refresh Fetch", isRefreshing.value.toString())
        }
    }
}
