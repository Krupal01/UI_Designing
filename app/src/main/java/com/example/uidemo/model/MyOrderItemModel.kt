package com.example.uidemo.model

import android.graphics.Bitmap
import java.io.Serializable

data class MyOrderModel(
    var orderNumber : Long,
    var orderDate : String,
    var orderStatus : String,
    var orderItems : ArrayList<MyOrderItemModel>,
    var orderDeliveryDate : String,
    var orderDeliveryType : String,
    var orderSubTotal : Long,
    var orderDiscount : Long,
    var orderStoreCreditAmount : Long,
    var orderCouponDiscount : Long,
    var orderGiftVoucher : Long,
    var orderLoyalityPoint : Long,
    var orderTotal : Long,
    var orderRefund : Long,

):Serializable{

    fun getTotalPrice():Long{
        var totalPrice : Long = 0
        for(i in orderItems){
            totalPrice += i.itemPrice
        }
        return totalPrice
    }
}

data class MyOrderItemModel(
 var itemImage : Bitmap?=null,
 var itemName : String,
 var itemColor : String,
 var itemPrice : Long,
 var itemQuantity : Long
):Serializable{
    fun getTotalPrice():Long{
        return itemPrice * itemQuantity
    }
}