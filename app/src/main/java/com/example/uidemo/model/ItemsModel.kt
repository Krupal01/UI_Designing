package com.example.uidemo.model

import android.graphics.Bitmap
import java.io.Serializable

data class ItemsModel(
    val title : String,
    val bitmap: Bitmap,
    val returnParam: ReturnParam? = ReturnParam("","",0,"",0),
    var price : Long?=0
) :Serializable {
}

data class ReturnParam(
    var return_SKU : String,
    var return_resolution : String,
    var return_amount : Long,
    var return_status : String,
    var return_qty : Int
) : Serializable{

}