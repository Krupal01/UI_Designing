package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.Model.CategoryModel
import com.example.uidemo.databinding.RowItemCategoriesBinding

class CategoryAdapter(val listener : CategoryClickListener) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var data : ArrayList<CategoryModel> = arrayListOf()

    interface CategoryClickListener{
        fun setOnCategoryClickLister(categoryModel: CategoryModel)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<CategoryModel>){
        this.data = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.CategoryViewHolder {
        var binding = RowItemCategoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        holder.bind(data[position])
        holder.binding.root.setOnClickListener {
            listener.setOnCategoryClickLister(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CategoryViewHolder(val binding: RowItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data : CategoryModel){
            binding.imgCategory.setImageBitmap(data.bitmap)
            binding.titleCategory.text = data.title
        }

    }

}