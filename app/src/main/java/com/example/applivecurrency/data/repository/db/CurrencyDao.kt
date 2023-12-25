package com.example.applivecurrency.data.repository.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.domain.payload.UpdateCurrencyRatesRequest

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currencies ORDER BY symbol ASC")
    fun getAllCurrencies() : LiveData<List<Currency>>
    @Query("SELECT * FROM currencies WHERE is_favorite = 1 ORDER BY symbol ASC")
    fun getFavorites():LiveData<List<Currency>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCurrency(currency: Currency)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertListOfCurrency(currencyList: List<Currency>)
    @Update
    suspend fun updateCurrency(currency:Currency)
    @Delete
    suspend fun deleteCurrency(currency: Currency)
    @Update(onConflict = OnConflictStrategy.REPLACE, entity = UpdateCurrencyRatesRequest::class)
    suspend fun updateCurrenciesRates(updateCurrenciesRates : List<UpdateCurrencyRatesRequest>)
}