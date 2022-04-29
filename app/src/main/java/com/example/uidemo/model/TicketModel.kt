package com.example.uidemo.model

import android.graphics.Bitmap

data class TicketModel(
    val ticketImage : Bitmap?,
    var adult : Int,
    var adultQAR: Int,
    var hashNumber : String,
    var title : String,
    var fromDate : String,
    var toDate : String,
    var fromTime : String,
    var toTime : String
)
