package com.app.coin.data.api

import com.app.coin.models.CoinResponse
import retrofit2.http.GET

interface CoinService {

    @GET("coinlist")
    suspend fun getList() : CoinResponse
}