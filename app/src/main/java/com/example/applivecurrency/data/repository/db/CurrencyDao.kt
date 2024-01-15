package com.example.applivecurrency.data.repository.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.applivecurrency.domain.model.Currency

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currencies ORDER BY symbol ASC")
    fun getAllCurrencies() : LiveData<List<Currency>>
    @Query("SELECT * FROM currencies WHERE is_favorite = 1 ORDER BY symbol ASC")
    fun getFavorites():LiveData<List<Currency>>
    @Query("SELECT * FROM currencies WHERE symbol = :symbol")
    suspend fun getCurrencyBySymbol(symbol: String): Currency?
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCurrency(currency: Currency)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListOfCurrency(currencyList: List<Currency>)
    @Update
    suspend fun updateCurrency(currency:Currency)
    @Delete
    suspend fun deleteCurrency(currency: Currency)
    @Query("UPDATE currencies SET rate = :newRate, change = :newChange WHERE symbol = :symbol")
    suspend fun updateCurrencyFields(symbol: String, newRate: Double, newChange: Double)
    @Transaction
    suspend fun upsertCurrency(currency: Currency) {
        val existingCurrency = getCurrencyBySymbol(currency.symbol)

        if (existingCurrency == null) {
            insertCurrency(currency)
        } else {
            updateCurrencyFields(currency.symbol, currency.rate, currency.change)
        }
    }
    @Transaction
    suspend fun upsertCurrenciesFields(currencies: List<Currency>) {
        for (currency in currencies) {
            upsertCurrency(currency)
        }
    }


}