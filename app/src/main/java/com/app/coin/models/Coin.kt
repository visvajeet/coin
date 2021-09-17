package com.app.coin.models

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import retrofit2.http.Field


@Keep
@Entity(tableName = "coin")
data class Coin(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("_id")
    val id: String,
    val name: String?,
    val pictures: Pictures?,

)

@Keep
data class Pictures(
    val front: Front?
)
@Keep
data class Front(
    val url: String?
)
@Keep
data class Data(
    val list: List<Coin>?
)




