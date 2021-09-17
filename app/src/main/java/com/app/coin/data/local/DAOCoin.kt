package com.app.coin.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.coin.models.Coin

@Dao
interface DAOCoin {

    @Query("SELECT * FROM coin")
    fun getCoins(): LiveData<List<Coin>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Coin>)

    @Query("DELETE FROM coin")
    fun deleteAll()

    @Transaction
    suspend fun deleteAndInsert(list: List<Coin>) {
        deleteAll()
        insertAll(list)
    }

}