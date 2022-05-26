package com.example.uidemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.R
import com.example.uidemo.databinding.RowItemWrapBinding
import com.example.uidemo.model.WrapperModel

class WrapperAdapter() : RecyclerView.Adapter<WrapperAdapter.WrapperViewHolder>() {

    var data = arrayListOf<WrapperModel>()

    fun submitData(data : ArrayList<WrapperModel>){
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WrapperViewHolder {
        val binding = RowItemWrapBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WrapperViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WrapperViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class WrapperViewHolder(val binding : RowItemWrapBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(wrapperModel: WrapperModel) {
            binding.wrapper = wrapperModel
            if (wrapperModel.isWrapperSelected == true){
                binding.imgWrap.setBackgroundResource(R.drawable.drawable_white_frame_orange_stoke)
            }else{
                binding.imgWrap.setBackgroundResource(0)
            }

            binding.root.setOnClickListener {
                if (wrapperModel.isWrapperSelected == true){
                    binding.imgWrap.setBackgroundResource(0)
                    wrapperModel.isWrapperSelected = false
                }else{
                    binding.imgWrap.setBackgroundResource(R.drawable.drawable_white_frame_orange_stoke)
                    wrapperModel.isWrapperSelected = true
                }
            }
        }
    }

}