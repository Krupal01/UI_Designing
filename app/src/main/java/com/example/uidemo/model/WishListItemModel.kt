package com.example.uidemo.model

import android.graphics.Bitmap

data class WishListItemModel(
    val name : String,
    val price : String,
    val quantity : Int,
    val imgBitmap: Bitmap? = null,
    val exclusive_preorder : String? = null,
    var isFavorite : Boolean = false,
    var mainPrice : Long?,
    var leftItem : Long?,
    var leftTime : String? = "00:00:00",

) {

    fun getHour(): String {
        return leftTime?.split(":")?.get(0) ?: "00"
    }
    fun getMinute(): String {
        return leftTime?.split(":")?.get(1) ?: "00"
    }
    fun getSecond(): String {
        return leftTime?.split(":")?.get(2) ?: "00"
    }

}