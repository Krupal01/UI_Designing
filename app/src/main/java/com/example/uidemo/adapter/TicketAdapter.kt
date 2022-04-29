package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemTicketBinding
import com.example.uidemo.model.TicketModel

class TicketAdapter : RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    private var data : ArrayList<TicketModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<TicketModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TicketViewHolder {
        val binding = RowItemTicketBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TicketViewHolder(val binding : RowItemTicketBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ticketModel: TicketModel) {
            binding.ticket = ticketModel
        }
    }

}