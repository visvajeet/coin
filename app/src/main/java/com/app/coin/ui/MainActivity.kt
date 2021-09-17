package com.app.coin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.app.coin.R
import com.app.coin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpNavigationWithBottomNav()

    }

    private fun setUpNavigationWithBottomNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostContainer) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavMenu.setupWithNavController(navController)

    }
}