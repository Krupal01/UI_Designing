package com.example.uidemo.model

import java.io.Serializable

data class CheckOutAddressModel(
    var address :String,
    var DeliveryCharge : Long,
    var isSelected : Boolean?
):Serializable
