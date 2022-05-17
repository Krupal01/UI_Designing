package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemMyOrderParentBinding
import com.example.uidemo.model.MyOrderItemModel

class MyOrderItemParentAdapter : RecyclerView.Adapter<MyOrderItemParentAdapter.MyOrderItemParentViewHolder>() {

    var data : ArrayList<MyOrderItemModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<MyOrderItemModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderItemParentViewHolder {
        val binding = RowItemMyOrderParentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyOrderItemParentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyOrderItemParentViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyOrderItemParentViewHolder(val binding : RowItemMyOrderParentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myOrderItemModel: MyOrderItemModel) {
            binding.ordersitem = myOrderItemModel
        }
    }

}