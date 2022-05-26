package com.example.uidemo.model

import android.graphics.Bitmap
import java.io.Serializable

data class WrapperModel(
    var wrapperImage : Bitmap?,
    var wrapperName : String,
    var wrapperPrice : Long?,
    var isWrapperSelected : Boolean? = false,
    var wrapperColor : String
) :Serializable{
}