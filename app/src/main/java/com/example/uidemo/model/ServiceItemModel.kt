package com.example.uidemo.model

import android.graphics.Bitmap
import java.io.Serializable

data class ServiceItemModel(
    var itemImage : Bitmap?=null,
    var itemName : String,
    var itemSentDate : String,
    var itemStatus : String,
    var itemLatestUpdateDate : String?= "No Update",
    var itemUpdates : ArrayList<ServiceItemUpdates>?= arrayListOf()
): Serializable {}

data class ServiceItemUpdates(
    var time : String,
    var comment : String
): Serializable{}