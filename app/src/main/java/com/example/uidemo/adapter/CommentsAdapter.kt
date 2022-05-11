package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemServiceUpdateCommentBinding
import com.example.uidemo.model.ServiceItemUpdates

class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>() {

    var data : ArrayList<ServiceItemUpdates> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<ServiceItemUpdates>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = RowItemServiceUpdateCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CommentViewHolder(val binding : RowItemServiceUpdateCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(serviceItemUpdates: ServiceItemUpdates){
            binding.comment = serviceItemUpdates
        }
    }
}