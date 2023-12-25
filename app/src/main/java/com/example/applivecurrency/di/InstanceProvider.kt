package com.example.applivecurrency.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.applivecurrency.data.repository.CurrencyRepository
import com.example.applivecurrency.data.repository.db.RoomLocalDatabase

class InstanceProvider : Application(){
    companion object{
        @Volatile
        private var _localDatabaseInstance : RoomLocalDatabase? = null
        @Volatile
        private var _currencyRepositoryInstance : CurrencyRepository? = null

        //RoomDatabase Singleton Instance
        fun provideLocalDatabase(context: Context) : RoomLocalDatabase{
            var tempInstance = _localDatabaseInstance

            if(tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context,
                        RoomLocalDatabase::class.java,
                        "app_live_currency_db"
                    )
                    .build()

                tempInstance = instance

                return instance
            }
        }

        //CurrencyRepository Singleton Instance
        fun provideCurrencyRepository(context: Context) : CurrencyRepository{
            var tempInstance = _currencyRepositoryInstance

            if(tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = CurrencyRepository(provideLocalDatabase(context).currencyDao())

                tempInstance = instance

                return instance
            }
        }
    }
}