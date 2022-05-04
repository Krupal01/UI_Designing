package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.R
import com.example.uidemo.databinding.RowItemAskReviewBinding
import com.example.uidemo.model.ReviewModel

class AskReviewAdapter : RecyclerView.Adapter<AskReviewAdapter.AskReviewViewHolder>() {

    var data : ArrayList<ReviewModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<ReviewModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AskReviewAdapter.AskReviewViewHolder {
        val binding = RowItemAskReviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AskReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AskReviewAdapter.AskReviewViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class AskReviewViewHolder(val binding : RowItemAskReviewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(reviewModel: ReviewModel) {
            binding.reviewModel = reviewModel

            binding.btnReviewItemFavorite.setOnClickListener {
                if (reviewModel.isFavourite == true){
                    reviewModel.isFavourite = false
                    binding.btnReviewItemFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }else{
                    reviewModel.isFavourite = true
                    binding.btnReviewItemFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                }
            }
        }
    }

}