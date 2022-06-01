package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.R
import com.example.uidemo.databinding.RowItemReviewOrdersItemBinding
import com.example.uidemo.model.MyOrderItemModel

class ReviewOrderItemAdapter : RecyclerView.Adapter<ReviewOrderItemAdapter.OrderViewHolder>() {

    var data : ArrayList<MyOrderItemModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<MyOrderItemModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewOrderItemAdapter.OrderViewHolder {
        val binding = RowItemReviewOrdersItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewOrderItemAdapter.OrderViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class OrderViewHolder(val binding: RowItemReviewOrdersItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myOrderItemModel: MyOrderItemModel) {
            binding.orderItem = myOrderItemModel

            binding.btnOrderItemFavorite.setOnClickListener {
                if (myOrderItemModel.isFavorite){
                    myOrderItemModel.isFavorite = false
                    binding.btnOrderItemFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }else{
                    myOrderItemModel.isFavorite = true
                    binding.btnOrderItemFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                }
            }
        }
    }

}