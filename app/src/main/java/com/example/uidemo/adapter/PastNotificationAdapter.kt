package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemPastNotificationBinding
import com.example.uidemo.model.PastNotificationModel

class PastNotificationAdapter : RecyclerView.Adapter<PastNotificationAdapter.PastNotificationViewHolder>() {

    var data : ArrayList<PastNotificationModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<PastNotificationModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PastNotificationAdapter.PastNotificationViewHolder {
        val binding = RowItemPastNotificationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PastNotificationViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PastNotificationAdapter.PastNotificationViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class PastNotificationViewHolder(val binding : RowItemPastNotificationBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dataItem : PastNotificationModel){
            binding.pastNotification = dataItem
        }
    }

}