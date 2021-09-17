package com.app.coin.data.local

import android.content.Context
import androidx.annotation.Keep
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.coin.models.Coin

@Keep
@Database(entities = [Coin::class], version = 1, exportSchema = false)
@TypeConverters(PictureConverter::class)
abstract class DatabaseClass : RoomDatabase() {

    abstract val daoCoin: DAOCoin

    companion object {

        @Volatile
        private var INSTANCE: DatabaseClass? = null

        fun getInstance(context: Context): DatabaseClass {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseClass::class.java,
                        "coin_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}