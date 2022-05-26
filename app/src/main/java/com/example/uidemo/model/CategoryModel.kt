package com.example.uidemo.model

import android.graphics.Bitmap
import java.io.Serializable

data class CategoryModel(
    val title : String,
    val bitmap: Bitmap
) : Serializable {

}