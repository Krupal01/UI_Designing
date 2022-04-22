package com.example.uidemo.model

import android.graphics.Bitmap

data class WishListItemModel(
    val name : String,
    val price : String,
    val quantity : Int,
    val imgBitmap: Bitmap? = null,
    val exclusive_preorder : String? = null,
    var isFavorite : Boolean = false

) {
}