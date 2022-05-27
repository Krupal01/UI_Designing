package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.R
import com.example.uidemo.databinding.RowItemSelectShippingAddressBinding
import com.example.uidemo.model.CheckOutAddressModel
import com.google.android.material.radiobutton.MaterialRadioButton


class CheckOutAddressAdapter : RecyclerView.Adapter<CheckOutAddressAdapter.AddressViewHolder>() {

    var data : ArrayList<CheckOutAddressModel> = arrayListOf()
    private var lastChecked: MaterialRadioButton? = null
    private var lastCheckedPos = 0

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<CheckOutAddressModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val binding = RowItemSelectShippingAddressBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AddressViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(data[position])
        holder.binding.rbAddress.tag = position

        if(position == 0 && data[position].isSelected == true && holder.binding.rbAddress.isChecked) {
            lastChecked = holder.binding.rbAddress
            lastCheckedPos = 0;
        }

        holder.binding.rbAddress.setOnClickListener {
            val cb = it as MaterialRadioButton
            val clickPos = (cb.tag as Int).toInt()
            if (cb.isChecked){
                if(lastChecked != null)
                {
                    lastChecked!!.isChecked = false
                    lastChecked!!.setBackgroundResource(R.drawable.drawable_custom_uncheck_radio_back)
                    data[lastCheckedPos].isSelected = false
                }
                lastChecked = cb
                lastCheckedPos = clickPos
                holder.binding.rbAddress.setBackgroundResource(R.drawable.drawable_custom_check_radio)
            }else{
                lastChecked = null
                data[clickPos].isSelected = false
                holder.binding.rbAddress.setBackgroundResource(R.drawable.drawable_custom_uncheck_radio_back)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class AddressViewHolder(val binding : RowItemSelectShippingAddressBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(checkOutAddressModel: CheckOutAddressModel) {
            binding.address = checkOutAddressModel

        }


    }

}