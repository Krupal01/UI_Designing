package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemMyOrderChildBinding
import com.example.uidemo.model.MyOrderItemModel

class MyOrderItemChildAdapter : RecyclerView.Adapter<MyOrderItemChildAdapter.MyOrderItemChildViewHolder>() {

    var data : ArrayList<MyOrderItemModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<MyOrderItemModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderItemChildViewHolder {
        val binding = RowItemMyOrderChildBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyOrderItemChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyOrderItemChildViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyOrderItemChildViewHolder(val binding : RowItemMyOrderChildBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myOrderItemModel: MyOrderItemModel) {
            binding.orderItems = myOrderItemModel
        }

    }
}

