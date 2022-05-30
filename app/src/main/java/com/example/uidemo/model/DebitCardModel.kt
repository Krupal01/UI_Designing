package com.example.uidemo.model

data class DebitCardModel(
    var cardNumber : String,
    var cardHolderName : String,
    var expiryDate : String,
    var cvcNumber : String,
    var cardType : String,
    var isSelected : Boolean?
)
