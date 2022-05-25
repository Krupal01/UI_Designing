package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemEventAndActivitiesBinding
import com.example.uidemo.model.EventAndActivitiesModel

class EventAdapter(val listener : EventClickListener) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    var data : ArrayList<EventAndActivitiesModel> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun submitDate(data : ArrayList<EventAndActivitiesModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface EventClickListener{
        fun setOnBuyTicketClickListener(data :EventAndActivitiesModel)
        fun setOnEventClickListener(data :EventAndActivitiesModel)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventViewHolder {
        val binding = RowItemEventAndActivitiesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(data[position],listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class EventViewHolder(val binding : RowItemEventAndActivitiesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(evenAndActivitiesModel: EventAndActivitiesModel, listener: EventClickListener) {
            binding.eventModel = evenAndActivitiesModel
            binding.root.setOnClickListener {
                listener.setOnEventClickListener(evenAndActivitiesModel)
            }
            binding.btnBuyTicket.setOnClickListener {
                listener.setOnBuyTicketClickListener(evenAndActivitiesModel)
            }
        }
    }

}