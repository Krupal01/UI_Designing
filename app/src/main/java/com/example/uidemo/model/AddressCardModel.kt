package com.example.uidemo.model

import java.io.Serializable

data class AddressCardModel(
    var AddressType : String,
    var username : String,
    var userEmail : String,
    var address : String,
    var PObox : String,
    var mobileNumber : String
):Serializable