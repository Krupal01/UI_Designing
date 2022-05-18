package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemOrderUpdatesBinding
import com.example.uidemo.model.OrderUpdate

class MyOrderUpdateAdapter : RecyclerView.Adapter<MyOrderUpdateAdapter.MyOrderUpdateViewHolder>() {

    var data : ArrayList<OrderUpdate> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<OrderUpdate>){
        this.data = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderUpdateViewHolder {
        val binding = RowItemOrderUpdatesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyOrderUpdateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyOrderUpdateViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyOrderUpdateViewHolder( val binding:RowItemOrderUpdatesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(orderUpdate: OrderUpdate) {
            binding.orderUpdate = orderUpdate
        }

    }

}