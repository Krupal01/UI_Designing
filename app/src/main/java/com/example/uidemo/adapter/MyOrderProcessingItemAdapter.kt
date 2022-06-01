package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.R
import com.example.uidemo.databinding.RowItemMyOrderParentProcessingBinding
import com.example.uidemo.model.MyOrderItemModel

class MyOrderProcessingItemAdapter(val listener : OnOrderItemClick) : RecyclerView.Adapter<MyOrderProcessingItemAdapter.MyOrderProcessingItemViewHolder>() {

    var data : ArrayList<MyOrderItemModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<MyOrderItemModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface OnOrderItemClick{
        fun setOnOrderItemClick(myOrderItemModel: MyOrderItemModel)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyOrderProcessingItemAdapter.MyOrderProcessingItemViewHolder {
        val binding = RowItemMyOrderParentProcessingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyOrderProcessingItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyOrderProcessingItemAdapter.MyOrderProcessingItemViewHolder,
        position: Int
    ) {
        holder.bind(data[position],listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyOrderProcessingItemViewHolder(val binding : RowItemMyOrderParentProcessingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myOrderItemModel: MyOrderItemModel, listener: OnOrderItemClick) {
            binding.orderItem = myOrderItemModel

            binding.btnItemFavorite.setOnClickListener {
                if (myOrderItemModel.isFavorite){
                    myOrderItemModel.isFavorite = false
                    binding.btnItemFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }else{
                    myOrderItemModel.isFavorite = true
                    binding.btnItemFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                }
            }

            binding.root.setOnClickListener {
                listener.setOnOrderItemClick(myOrderItemModel)
            }

        }
    }

}