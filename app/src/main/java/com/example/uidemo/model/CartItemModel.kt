package com.example.uidemo.model

import android.graphics.Bitmap
import java.io.Serializable

data class CartItemModel(
    val cartItemImage : Bitmap?,
    val cartItemName : String,
    val cartItemColor : String,
    val wrapperModel: WrapperModel?,
    val cartItemOptions: ArrayList<CartItemOption>?,
    val IsFavorite : Boolean ? = false,
    val cartTotalPrice : Long
):Serializable

data class CartItemOption(
    val optionImage : Bitmap?,
    val optionName : String,
    val optionMainPrice : Long,
    val OptionOfferPrice : Long,
):Serializable
