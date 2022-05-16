package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemReturnRequestForBinding
import com.example.uidemo.model.ItemsModel

class RequestForReturnAdapter : RecyclerView.Adapter<RequestForReturnAdapter.RequestViewHolder>() {

    var data : ArrayList<ItemsModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<ItemsModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val binding = RowItemReturnRequestForBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RequestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class RequestViewHolder(val binding : RowItemReturnRequestForBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemsModel: ItemsModel) {
            binding.item = itemsModel
        }
    }

}