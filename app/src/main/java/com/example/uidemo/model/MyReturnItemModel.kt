package com.example.uidemo.model

import java.io.Serializable

data class MyReturnItemModel(
    var RMA : Long,
    var date : String,
    var orderNumber : String,
    var Amount : Long,
    var shippingSource : String,
    var returnItems : ArrayList<ItemsModel>,
    var returnItemStatus:String,
    var mailFrom : String,
    val orderShippingAddress : AddressCardModel,
):Serializable{

}
