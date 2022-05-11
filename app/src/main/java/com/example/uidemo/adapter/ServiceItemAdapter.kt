package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemServiceCardBinding
import com.example.uidemo.model.ServiceItemModel

class ServiceItemAdapter(val listener : OnServiceItemClick) : RecyclerView.Adapter<ServiceItemAdapter.ServiceCardViewHolder>() {

    var data : ArrayList<ServiceItemModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<ServiceItemModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface OnServiceItemClick{
        fun setOnSeeDetailsClickListener(serviceItemModel: ServiceItemModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceCardViewHolder {
        val biniding = RowItemServiceCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ServiceCardViewHolder(biniding)
    }

    override fun onBindViewHolder(holder: ServiceCardViewHolder, position: Int) {
        holder.bind(data[position],listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ServiceCardViewHolder(val binding: RowItemServiceCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(serviceItemModel: ServiceItemModel, listener: OnServiceItemClick){
            binding.serviceItem = serviceItemModel

            binding.btnSeeAll.setOnClickListener {
                listener.setOnSeeDetailsClickListener(serviceItemModel)
            }
        }
    }

}