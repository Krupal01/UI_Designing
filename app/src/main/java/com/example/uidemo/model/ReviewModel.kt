package com.example.uidemo.model

import android.graphics.Bitmap
import java.io.Serializable

data class ReviewModel(
    val image: Bitmap?,
    val name: String,
    val price: Long,
    val QTY: Long,
    val rating: Float?,
    val review: String?,
    var isFavourite: Boolean? = false,
    var created: String
) : Serializable{}
