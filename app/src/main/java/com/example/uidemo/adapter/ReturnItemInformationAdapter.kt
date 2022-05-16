package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.R
import com.example.uidemo.databinding.RowItemReturnItemInformationBinding
import com.example.uidemo.model.ItemsModel
import com.example.uidemo.utils.FakeData

class ReturnItemInformationAdapter : RecyclerView.Adapter<ReturnItemInformationAdapter.ItemViewHolder>() {

    private var data : ArrayList<ItemsModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<ItemsModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var binding = RowItemReturnItemInformationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setViews()
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ItemViewHolder(val binding : RowItemReturnItemInformationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemsModel: ItemsModel) {
            binding.itemModel = itemsModel
            binding.itemCheckBox.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    binding.itemLayout2.visibility = View.VISIBLE
                    binding.itemCheckLayout.setBackgroundResource(R.drawable.custom_checked_layout)
                }else{
                    binding.itemLayout2.visibility = View.GONE
                    binding.itemCheckLayout.setBackgroundResource(R.drawable.custom_unchecked_layout)
                }
            }
        }
        fun setViews(){
            if (binding.itemCheckBox.isChecked){
                binding.itemLayout2.visibility = View.VISIBLE
                binding.itemCheckLayout.setBackgroundResource(R.drawable.custom_checked_layout)
            }else{
                binding.itemLayout2.visibility = View.GONE
                binding.itemCheckLayout.setBackgroundResource(R.drawable.custom_unchecked_layout)
            }

            binding.etQuantity.setAdapter(ArrayAdapter(
                binding.root.context,
                android.R.layout.simple_dropdown_item_1line,
                binding.root.resources.getStringArray(R.array.Quantity))
            )

            binding.etItemCondition.setAdapter(ArrayAdapter(
                binding.root.context,
                android.R.layout.simple_dropdown_item_1line,
                binding.root.resources.getStringArray(R.array.itemCondition))
            )

            binding.etReason.setAdapter(ArrayAdapter(
                binding.root.context,
                android.R.layout.simple_dropdown_item_1line,
                binding.root.resources.getStringArray(R.array.reasonForReturn))
            )

            binding.etResolution.setAdapter(ArrayAdapter(
                binding.root.context,
                android.R.layout.simple_dropdown_item_1line,
                binding.root.resources.getStringArray(R.array.resolution))
            )
        }

    }

}