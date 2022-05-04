package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemReviewCardBinding
import com.example.uidemo.model.ReviewModel

class ReviewCardAdapter(val listener : viewMoreClickListener) : RecyclerView.Adapter<ReviewCardAdapter.CardviewHolder>() {

    var data : ArrayList<ReviewModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<ReviewModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface viewMoreClickListener {
        fun setOnViewMoreClickListener(reviewModel: ReviewModel)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewCardAdapter.CardviewHolder {
        val binding = RowItemReviewCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardviewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewCardAdapter.CardviewHolder, position: Int) {
        holder.bind(data[position])
        holder.binding.btnReviewDetails.setOnClickListener {
            listener.setOnViewMoreClickListener(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CardviewHolder(val binding : RowItemReviewCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(reviewModel: ReviewModel) {
            binding.reviewModel = reviewModel
        }
    }

}