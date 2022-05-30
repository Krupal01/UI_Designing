package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.R
import com.example.uidemo.databinding.RowItemSelectPaymentCardBinding
import com.example.uidemo.model.DebitCardModel
import com.google.android.material.radiobutton.MaterialRadioButton

class SelectCardAdapter : RecyclerView.Adapter<SelectCardAdapter.SelectViewHolder>() {


    var data : ArrayList<DebitCardModel> = arrayListOf()
    private var lastChecked: View? = null
    private var lastSelectedPos:Int? = null

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<DebitCardModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectCardAdapter.SelectViewHolder {
        val binding = RowItemSelectPaymentCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SelectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectCardAdapter.SelectViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(data[position])
        holder.binding.root.tag = position

        if(data[position].isSelected == true ) {
            lastChecked = holder.binding.root
            lastSelectedPos = position
            holder.binding.root.setBackgroundResource(R.drawable.drawable_strock_pinkyellow1_corner5)
        }

        holder.binding.root.setOnClickListener {
            val clickPos = it.tag as Int
            if (!it.isSelected && lastSelectedPos != clickPos){
                if(lastChecked != null)
                {
                    lastChecked!!.isSelected = false
                    lastChecked!!.setBackgroundResource(R.drawable.card_number_text_drawable)
                    data[lastSelectedPos!!].isSelected = false
                }
                lastChecked = it
                lastSelectedPos = clickPos
                holder.binding.root.setBackgroundResource(R.drawable.drawable_strock_pinkyellow1_corner5)
            }else{
                lastChecked = null
                data[clickPos].isSelected = false
                lastSelectedPos = null
                holder.binding.root.setBackgroundResource(R.drawable.card_number_text_drawable)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class SelectViewHolder(val binding:RowItemSelectPaymentCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(debitCardModel: DebitCardModel) {
            binding.cardInfo = debitCardModel


        }
    }

}