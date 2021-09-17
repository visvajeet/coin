package com.app.coin.data.local

import androidx.room.TypeConverter
import com.app.coin.models.Front
import com.app.coin.models.Pictures

class PictureConverter {

    @TypeConverter
    fun fromPicture(pictures: Pictures?) :String{
        return pictures?.front?.url.toString()
    }
    @TypeConverter
    fun  toPictureUrl(url: String): Pictures {
        return Pictures( Front(url))
    }
}