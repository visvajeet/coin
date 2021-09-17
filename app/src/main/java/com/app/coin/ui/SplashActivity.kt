package com.app.coin.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.coin.R
import com.app.coin.databinding.ActivitySplashBinding
import com.app.coin.utils.Status
import com.app.coin.viewmodels.SplashViewModel


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        observe()

    }

    private fun observe() {
        viewModel.coin.observe(this, {
            if (it.status == Status.SUCCESS) {
                openMainActivity()
            }
        })
    }

    private fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}