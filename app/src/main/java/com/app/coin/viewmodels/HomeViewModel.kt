package com.app.coin.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.coin.data.local.DAOCoin
import com.app.coin.data.local.DatabaseClass
import com.app.coin.data.repository.CoinRepository
import com.app.coin.models.Coin
import com.app.coin.models.CoinResponse
import com.app.coin.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repo : CoinRepository by lazy { CoinRepository(application) }

    val coins: LiveData<List<Coin>> = repo.getCoins()

}