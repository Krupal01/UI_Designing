package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemEventSpeakerBinding
import com.example.uidemo.model.EventSpeaker

class EventSpeakerAdapter : RecyclerView.Adapter<EventSpeakerAdapter.EventSpeakerViewHolder>() {

    var data : ArrayList<EventSpeaker> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun submitDate(data : ArrayList<EventSpeaker>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventSpeakerViewHolder {
        val binding  = RowItemEventSpeakerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EventSpeakerViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: EventSpeakerViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class EventSpeakerViewHolder(val binding : RowItemEventSpeakerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(eventSpeaker: EventSpeaker) {
            binding.speaker = eventSpeaker
        }
    }

}