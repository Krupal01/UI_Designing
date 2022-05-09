package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemDefaultAddressBinding
import com.example.uidemo.model.AddressCardModel

class DefaultAddressCardAdapter(val listener : DefaultItemClick) : RecyclerView.Adapter<DefaultAddressCardAdapter.CardViewHolder>() {

    var data : ArrayList<AddressCardModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<AddressCardModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface DefaultItemClick{
        fun onDefaultAddressItemClick(addressCardModel: AddressCardModel)
        fun onDefaultAddressEditClick(addressCardModel: AddressCardModel)
    }
    


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DefaultAddressCardAdapter.CardViewHolder {
        val binding  = RowItemDefaultAddressBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DefaultAddressCardAdapter.CardViewHolder, position: Int) {
        holder.bind(data[position] ,listener )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CardViewHolder(val binding: RowItemDefaultAddressBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(addressCardModel: AddressCardModel, listener: DefaultItemClick) {
            binding.address = addressCardModel
            binding.root.setOnClickListener {
                listener.onDefaultAddressItemClick(addressCardModel)
            }
            binding.btnAddressEdit.setOnClickListener {
                listener.onDefaultAddressEditClick(addressCardModel)
            }
        }
    }

}