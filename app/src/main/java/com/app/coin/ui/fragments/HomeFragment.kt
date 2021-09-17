package com.app.coin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.coin.R
import com.app.coin.adapters.CoinAdapter
import com.app.coin.databinding.FragmentHomeBinding
import com.app.coin.viewmodels.HomeViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var adapter: CoinAdapter
    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUI()
        setAdapter()
        observerData()
    }

    private fun setUI() {
        binding.apply {
            cvScan.tvTitle.text = requireContext().getString(R.string.scan)
            cvSell.tvTitle.text = requireContext().getString(R.string.sell)
        }
    }

    private fun setAdapter() {
        adapter = CoinAdapter()
        binding.layoutBuy.rv.adapter = adapter
    }

    private fun observerData() {
        viewModel.coins.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }


}