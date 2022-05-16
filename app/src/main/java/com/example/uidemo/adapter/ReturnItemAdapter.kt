package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.databinding.RowItemMyReturnsBinding
import com.example.uidemo.model.ItemsModel
import com.example.uidemo.model.MyReturnItemModel

class ReturnItemAdapter(
    val listener : ClickListener
) : RecyclerView.Adapter<ReturnItemAdapter.ReturnItemViewHolder>() {

    private var data : ArrayList<MyReturnItemModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<MyReturnItemModel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface ClickListener{
        fun setOnReturnItemClick(data : MyReturnItemModel)
        fun viewReturnItemClick(data : MyReturnItemModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReturnItemViewHolder {
        val binding = RowItemMyReturnsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ReturnItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReturnItemViewHolder, position: Int) {
        holder.bind(data[position],listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ReturnItemViewHolder(val binding : RowItemMyReturnsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            myReturnItemModel: MyReturnItemModel,
            listener: ClickListener
        ) {
            binding.returnItem = myReturnItemModel
            binding.root.setOnClickListener { listener.setOnReturnItemClick(myReturnItemModel) }
            binding.tvViewReturns.setOnClickListener { listener.viewReturnItemClick(myReturnItemModel) }
            setChildRecycler(myReturnItemModel.returnItems)
        }

        private fun setChildRecycler(returnItems: ArrayList<ItemsModel>) {
            val childAdapter = CartNotificationScrAdapter()
            val childLayoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL,false)
            binding.rcvReturnsItems.layoutManager = childLayoutManager
            binding.rcvReturnsItems.adapter = childAdapter
            childAdapter.submitData(returnItems)
        }
    }

}