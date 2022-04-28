package com.example.uidemo.model

data class TransactionModel(
    var orderNumber : String,
    var point : Long,
    var totalItemsCount : Int,
    var totalItemsQAR : Long,
    var availablePoint : Long,
    var date : String,
    var time : String
)
