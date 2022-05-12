package com.example.uidemo.model

import java.io.Serializable

data class UserPersonalInfoModel(
    var firstName : String,
    var lastName : String,
    var emailAddress : String,
    var mobile : String,
    var DateOfBirth : String
) : Serializable{}
