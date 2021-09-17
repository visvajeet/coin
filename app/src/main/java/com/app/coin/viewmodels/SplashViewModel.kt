package com.app.coin.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.coin.data.repository.CoinRepository
import com.app.coin.models.CoinResponse
import com.app.coin.utils.Resource
import kotlinx.coroutines.launch
import java.io.IOException

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val _coin = MutableLiveData<Resource<CoinResponse>>()
    val coin: LiveData<Resource<CoinResponse>> = _coin

    private val repo: CoinRepository by lazy { CoinRepository(application) }

    init {
        getCoins()
    }

    private fun getCoins() {

        viewModelScope.launch {

            _coin.postValue(Resource.loading(data = null))

            try {
                val data = repo.loadCoinsAndSaveToDatabase()
                _coin.postValue(Resource.success(data = data))
            } catch (e: Exception) {
                val msg = if(e is IOException) "Check Internet connection" else e.message.toString()
                _coin.postValue(Resource.error(data = null, message = msg))
            }
        }
    }

    fun retry() {
        getCoins()
    }


}