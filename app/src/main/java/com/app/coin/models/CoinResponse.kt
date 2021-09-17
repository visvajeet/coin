package com.app.coin.models

import androidx.annotation.Keep


@Keep
data class CoinResponse(
   val result: Int?,
   val msg: String?,
   val data: Data?
)
