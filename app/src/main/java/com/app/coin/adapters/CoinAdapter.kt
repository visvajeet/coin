package com.app.coin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.coin.databinding.ListItemCoinBinding
import com.app.coin.models.Coin


class CoinAdapter() : ListAdapter<Coin, CoinAdapter.MyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemCoinBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    class MyViewHolder(private var binding: ListItemCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(coin: Coin) {
            binding.coin = coin
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.name == newItem.name
        }
    }

}