package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemMyOrderBinding
import com.example.uidemo.model.MyOrderItemModel
import com.example.uidemo.model.MyOrderModel

class MyOrderAdapter(val listener : OrderItemClick) : RecyclerView.Adapter<MyOrderAdapter.MyOrderViewHolder>(){

    var data : ArrayList<MyOrderModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<MyOrderModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface OrderItemClick{
        fun setOnItemClickListener(myOrderModel: MyOrderModel)
        fun setOnViewDetailsListener(myOrderModel: MyOrderModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderViewHolder {
        val binding = RowItemMyOrderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyOrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyOrderViewHolder, position: Int) {
        holder.bind(data[position])
        holder.binding.root.setOnClickListener {
            listener.setOnItemClickListener(data[position])
        }
        holder.binding.tvViewDetails.setOnClickListener {
            listener.setOnViewDetailsListener(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyOrderViewHolder(val binding  :RowItemMyOrderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myOrderModel: MyOrderModel) {
            binding.myOrder = myOrderModel
            setOrderItemsChildRecycler(myOrderModel.orderItems)
        }

        private fun setOrderItemsChildRecycler(orderItems: ArrayList<MyOrderItemModel>) {
            val adapter = MyOrderItemChildAdapter()
            binding.rcvOrderItems.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.HORIZONTAL,false)
            binding.rcvOrderItems.adapter = adapter
            adapter.submitData(orderItems)
        }

    }


}