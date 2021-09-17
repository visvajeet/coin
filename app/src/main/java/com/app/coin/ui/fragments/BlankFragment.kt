package com.app.coin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.coin.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root

    }


}