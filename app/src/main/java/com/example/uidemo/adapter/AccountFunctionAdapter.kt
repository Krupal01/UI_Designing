package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.model.AccountFunctionModel
import com.example.uidemo.databinding.RowItemFunctionBinding

class AccountFunctionAdapter(val listener: OnFunctionClick) : RecyclerView.Adapter<AccountFunctionAdapter.FunctionViewHolder>() {

    var data : ArrayList<AccountFunctionModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<AccountFunctionModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface OnFunctionClick{
        fun setOnFunctionClickListener(accountFunctionModel: AccountFunctionModel)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AccountFunctionAdapter.FunctionViewHolder {
        val binding = RowItemFunctionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FunctionViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: AccountFunctionAdapter.FunctionViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
        holder.binding.root.setOnClickListener {
            listener.setOnFunctionClickListener(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class FunctionViewHolder(val binding: RowItemFunctionBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: AccountFunctionModel) {
            binding.functionItem = item
        }
    }

}