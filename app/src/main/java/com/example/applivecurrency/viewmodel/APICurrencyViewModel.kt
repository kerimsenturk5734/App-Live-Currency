import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.applivecurrency.data.api.APICurrencyService.apiService
import com.example.applivecurrency.data.api.payload.APICurrencyToAllResponse
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.domain.CurrencyMapper
import com.example.applivecurrency.domain.model.Currency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APICurrencyViewModel(context: Context) : ViewModel() {
    val currencyViewModel = InstanceProvider.provideCurrencyViewModel(context)

    private val _currencyData = MutableLiveData<List<Currency>>()
    val currencyData: LiveData<List<Currency>> get() = _currencyData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchData(baseCurrency: String, quantity: Int) {
        apiService.callCurrencyToAll(baseCurrency, quantity).enqueue(object : Callback<APICurrencyToAllResponse> {
            override fun onResponse(call: Call<APICurrencyToAllResponse>, response: Response<APICurrencyToAllResponse>) {
                if (response.isSuccessful) {
                    Log.d("API Data Success", response.code().toString())
                    _currencyData.value = response.body()
                        ?.let { CurrencyMapper().APICurrenciesToCurrencies(it.result.data) }

                    response.body()
                        ?.let { CurrencyMapper().APICurrenciesToCurrencies(it.result.data) }
                        ?.let { currencyViewModel.upsertCurrenciesFields(it) }
                } else {
                    Log.d("API Data Failed", response.message()+response.code())
                    _error.value = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<APICurrencyToAllResponse>, t: Throwable) {
                _error.value = "Network error: ${t.message}"
                Log.d("API Error", _error.value!!)
            }

        })
    }
}
