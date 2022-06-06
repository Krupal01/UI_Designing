package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemItemSpecificationBinding
import com.example.uidemo.model.ProductSpecificationModel

class ProductSpecificationAdapter :
    RecyclerView.Adapter<ProductSpecificationAdapter.SpecificationViewHolder>() {

    var data : ArrayList<ProductSpecificationModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<ProductSpecificationModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecificationViewHolder {
        val binding = RowItemItemSpecificationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SpecificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpecificationViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class SpecificationViewHolder(val binding : RowItemItemSpecificationBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(productSpecificationModel: ProductSpecificationModel) {
            binding.specification = productSpecificationModel
        }
    }
}