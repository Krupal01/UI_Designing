package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemNotificationCartItemsBinding
import com.example.uidemo.model.ItemsModel

class CartNotificationScrAdapter : RecyclerView.Adapter<CartNotificationScrAdapter.CartNotificationScrViewHolder>() {

    private var data : ArrayList<ItemsModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<ItemsModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartNotificationScrAdapter.CartNotificationScrViewHolder {
        val binding = RowItemNotificationCartItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartNotificationScrViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CartNotificationScrAdapter.CartNotificationScrViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CartNotificationScrViewHolder(var binding : RowItemNotificationCartItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(dataItem : ItemsModel){
            binding.itemModel = dataItem
        }
    }
}