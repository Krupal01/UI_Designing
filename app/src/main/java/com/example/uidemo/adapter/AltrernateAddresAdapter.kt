package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemAlternateAddressBinding
import com.example.uidemo.model.AddressCardModel

class AltrernateAddresAdapter(val listener : AlternateItemClick) : RecyclerView.Adapter<AltrernateAddresAdapter.CardViewHolder>() {

    var data : ArrayList<AddressCardModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<AddressCardModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface AlternateItemClick{
        fun onAlternateAddressItemClick(addressCardModel: AddressCardModel)
        fun onAlternateAddressMenuClick(addressCardModel: AddressCardModel, view : View)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AltrernateAddresAdapter.CardViewHolder {
        val binding = RowItemAlternateAddressBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AltrernateAddresAdapter.CardViewHolder, position: Int) {
        holder.bind(data[position],listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CardViewHolder(val binding: RowItemAlternateAddressBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(addressCardModel: AddressCardModel, listener: AlternateItemClick) {
            binding.address = addressCardModel
            binding.root.setOnClickListener {
                listener.onAlternateAddressItemClick(addressCardModel)
            }
            binding.btnAlternateAddressMenu.setOnClickListener {
                listener.onAlternateAddressMenuClick(addressCardModel,it)
            }
        }
    }
}