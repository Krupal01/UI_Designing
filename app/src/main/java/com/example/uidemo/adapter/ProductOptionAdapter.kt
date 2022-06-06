package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemFunctionBinding
import com.example.uidemo.databinding.RowItemProductOptionBinding
import com.example.uidemo.model.AccountFunctionModel

class ProductOptionAdapter : RecyclerView.Adapter<ProductOptionAdapter.ProductOptionViewHolder>() {

    var data : ArrayList<AccountFunctionModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<AccountFunctionModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductOptionAdapter.ProductOptionViewHolder {
        val binding = RowItemProductOptionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductOptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductOptionAdapter.ProductOptionViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ProductOptionViewHolder(val binding: RowItemProductOptionBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: AccountFunctionModel) {
            binding.functionItem = item
        }
    }

}