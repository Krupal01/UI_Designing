package com.example.uidemo.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.uidemo.R
import com.example.uidemo.databinding.RowItemParentRecentListItemBinding
import com.example.uidemo.model.WishListItemModel

class RecentListParentAdapter : RecyclerView.Adapter<RecentListParentAdapter.RecentListParentViewHolder>() {

    var data : ArrayList<WishListItemModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data : ArrayList<WishListItemModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentListParentViewHolder {
        val binding = RowItemParentRecentListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecentListParentViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: RecentListParentViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class RecentListParentViewHolder(val binding: RowItemParentRecentListItemBinding) : RecyclerView.ViewHolder(binding.root){
        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(wishListItemModel: WishListItemModel) {
            binding.wishlistItem = wishListItemModel
            setView(wishListItemModel.exclusive_preorder)

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

        @RequiresApi(Build.VERSION_CODES.M)
        fun setView(exclusivePreorder: String?) {
            binding.tvExclusivePreorder.text = exclusivePreorder
            when(exclusivePreorder){
                null ->{
                    setItemView(View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,R.color.teal_500,R.drawable.null_item_drawable,R.color.black,binding.root.context.resources.getString(R.string.add_to_cart))
                }
                binding.root.context.resources.getString(R.string.exclusive) ->{
                    setItemView(View.VISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,R.color.black,R.drawable.exlusive_item_drawable,R.color.black,binding.root.context.resources.getString(R.string.add_to_cart))
                }
                binding.root.context.resources.getString(R.string.pre_order) ->{
                    setItemView(View.VISIBLE,View.INVISIBLE,View.INVISIBLE,View.VISIBLE,View.VISIBLE,R.color.teal_500,R.drawable.pre_order_item_drawable,R.color.orange,binding.root.context.resources.getString(R.string.pre_order))
                }
                binding.root.context.resources.getString(R.string.offer) ->{
                    setItemView(View.VISIBLE,View.VISIBLE,View.VISIBLE,View.VISIBLE,View.VISIBLE,R.color.red_F36969,R.drawable.drawable_wishlist_offer,R.color.red_F36969,binding.root.context.resources.getString(R.string.add_to_cart))
                }
                binding.root.context.resources.getString(R.string._new) ->{
                    setItemView(View.VISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,R.color.teal_500,R.drawable.drawable_wishlist_new,R.color.light_coffee,binding.root.context.resources.getString(R.string.add_to_cart))
                }
                else -> if(exclusivePreorder.contains("off")){
                    setItemView(View.VISIBLE,View.VISIBLE,View.VISIBLE,View.VISIBLE,View.VISIBLE,R.color.red_F36969,R.drawable.pre_order_item_drawable,R.color.red_F36969,binding.root.context.resources.getString(R.string.add_to_cart))
                }else{
                    setItemView(View.VISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,R.color.teal_500,R.drawable.drawable_wishlist_gift,R.color.teal_500,binding.root.context.resources.getString(R.string.add_to_cart))
                }
            }
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        @RequiresApi(Build.VERSION_CODES.M)
        fun setItemView(
            tvExclusivePreorderVisible: Int,
            tvMainPriceFavoriteItemVisible1: Int,
            tvLeftFavoriteItemVisible2: Int,
            tvQuantityVisibility : Int,
            layoutTimeVisible3: Int,
            btnAddToCartColor: Int,
            RootBackground: Int,
            tvExclusiveBlack1: Int,
            btnAddToCartText : String
        ) {
            binding.tvExclusivePreorder.visibility = tvExclusivePreorderVisible
            binding.tvMainPriceFavoriteItem.visibility = tvMainPriceFavoriteItemVisible1
            binding.tvLeftFavoriteItem.visibility = tvLeftFavoriteItemVisible2
            binding.layoutTime.visibility = layoutTimeVisible3
            binding.tvQuantityFavoriteItem.visibility = tvQuantityVisibility
            binding.btnAddToCartFavoriteItem.setBackgroundColor(binding.root.context.resources.getColor(
                btnAddToCartColor, null))
            binding.root.background = binding.root.context.resources.getDrawable(RootBackground,null)
            binding.tvExclusivePreorder.setBackgroundColor(binding.root.context.resources.getColor(
                tvExclusiveBlack1,null))
            binding.btnAddToCartFavoriteItem.text = btnAddToCartText
        }
    }

}