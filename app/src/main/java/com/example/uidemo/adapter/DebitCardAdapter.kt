package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemDebitCardBinding
import com.example.uidemo.model.DebitCardModel

class DebitCardAdapter(var listener : OnCardClick) : RecyclerView.Adapter<DebitCardAdapter.CardViewModel>() {

    var data : ArrayList<DebitCardModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<DebitCardModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface OnCardClick{
        fun setOnCardClickListener(debitCard: DebitCardModel, view: View)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DebitCardAdapter.CardViewModel {
        val binding = RowItemDebitCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardViewModel(binding)
    }

    override fun onBindViewHolder(holder: DebitCardAdapter.CardViewModel, position: Int) {
        holder.bind(data[position])
        holder.binding.btnDefaultCardMenu.setOnClickListener {
            listener.setOnCardClickListener(data[position],it)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CardViewModel(val binding: RowItemDebitCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(debitCard: DebitCardModel){
            binding.debitCard = debitCard
        }
    }

}