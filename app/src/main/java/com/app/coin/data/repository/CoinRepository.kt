package com.app.coin.data.repository

import android.app.Application
import com.app.coin.data.api.RetrofitBuilder
import com.app.coin.data.local.DAOCoin
import com.app.coin.data.local.DatabaseClass
import com.app.coin.models.CoinResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CoinRepository(app: Application) {

    private val daoCoin: DAOCoin by lazy {
        DatabaseClass.getInstance(app).daoCoin
    }
    private val api = RetrofitBuilder.apiService

    suspend fun loadCoinsAndSaveToDatabase(): CoinResponse {

        return withContext(Dispatchers.IO) {
            val response = api.getList()
            daoCoin.deleteAndInsert(response.data?.list ?: emptyList())
            response
        }
    }

    fun getCoins() = daoCoin.getCoins()


}