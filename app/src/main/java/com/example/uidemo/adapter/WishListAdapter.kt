package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.model.WishListItemModel
import com.example.uidemo.R
import com.example.uidemo.databinding.RowItemWishlistBinding

class WishListAdapter : RecyclerView.Adapter<WishListAdapter.ItemViewHolder>() {

    var data : ArrayList<WishListItemModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<WishListItemModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WishListAdapter.ItemViewHolder {
        val binding = RowItemWishlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: WishListAdapter.ItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ItemViewHolder(private val binding:RowItemWishlistBinding) : RecyclerView.ViewHolder(binding.root) {

        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(wishListItemModel: WishListItemModel){
            cardDesign(wishListItemModel.exclusive_preorder,wishListItemModel.isFavorite)

            binding.wishListItem = wishListItemModel

            binding.btnItemFavorite.setOnClickListener {
                if (wishListItemModel.isFavorite){
                    wishListItemModel.isFavorite = false
                    binding.btnItemFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }else{
                    wishListItemModel.isFavorite = true
                    binding.btnItemFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                }
            }
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        @RequiresApi(Build.VERSION_CODES.M)
        private fun cardDesign(exclusive_preorder: String?, isFavorite: Boolean) {

            if (exclusive_preorder == null){
                binding.root.background = binding.root.context.resources.getDrawable(R.drawable.null_item_drawable,null)
                binding.btnAddToCartFavoriteItem.setBackgroundColor(binding.root.context.resources.getColor(R.color.teal_700,null))
                binding.tvExclusivePreorder.visibility = View.INVISIBLE
            }else{
                binding.tvExclusivePreorder.visibility = View.VISIBLE
                if (exclusive_preorder == binding.root.context.resources.getString(R.string.exclusive)){
                    binding.root.background = binding.root.context.resources.getDrawable(R.drawable.exlusive_item_drawable,null)
                    binding.btnAddToCartFavoriteItem.setBackgroundColor(binding.root.context.resources.getColor(R.color.black,null))
                    binding.tvExclusivePreorder.setBackgroundColor(binding.root.context.resources.getColor(R.color.black,null))
                    binding.tvExclusivePreorder.text = binding.root.context.resources.getString(R.string.exclusive)
                }else{
                    binding.root.background = binding.root.context.resources.getDrawable(R.drawable.pre_order_item_drawable,null)
                    binding.btnAddToCartFavoriteItem.setBackgroundColor(binding.root.context.resources.getColor(R.color.teal_700,null))
                    binding.tvExclusivePreorder.setBackgroundColor(binding.root.context.resources.getColor(R.color.orange,null))
                    binding.tvExclusivePreorder.text = binding.root.context.resources.getString(R.string.pre_order)
                }

            }

        }
    }
}