package com.app.coin.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageUrl")
fun setImageUrl(iv: ImageView?, url: String?) {
    iv?.let {
        if (!url.isNullOrEmpty()) {
            Glide.with(it.context).load(url).into(iv)
        }
    }
}