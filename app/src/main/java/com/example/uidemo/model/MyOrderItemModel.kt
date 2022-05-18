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
    var orderLatestUpdates : ArrayList<OrderUpdate>? = arrayListOf(),
    var orderLatestUpdateDate : String ? = orderDeliveryDate,
    var orderDeliveryInfo: DeliveryInfo

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
 var itemQuantity : Int,
 var itemTime : String? = "00:00:00",
 var isFavorite : Boolean = false
):Serializable{
    fun getTotalPrice():Long{
        return itemPrice * itemQuantity
    }
    fun getHour(): String {
        return itemTime?.split(":")?.get(0) ?: "00"
    }
    fun getMinute(): String {
        return itemTime?.split(":")?.get(1) ?: "00"
    }
    fun getSecond(): String {
        return itemTime?.split(":")?.get(2) ?: "00"
    }
}

data class OrderUpdate(
    var time:String,
    var MsgBy : String,
    var Msg : String
) : Serializable{}

data class DeliveryInfo(
    var TTNnumber : String,
    var route : String,
    var DeliveryAddress : String
): Serializable{}