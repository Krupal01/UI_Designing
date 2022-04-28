package com.example.uidemo.utils

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import com.example.uidemo.model.*
import java.io.IOException
import java.io.InputStream


class FakeData {

    fun fakeCategories(context: Context , dir_name : String) : ArrayList<CategoryModel>{
        val category : ArrayList<CategoryModel> = arrayListOf()

        val list: Array<String>
        try {
            list = context.assets.list(dir_name) as Array<String>
            if (list.isNotEmpty()) {
                for (fileName in list) {
                    val istr: InputStream = context.assets.open("$dir_name/$fileName")
                    val bitmap = BitmapFactory.decodeStream(istr)
                    category.add(CategoryModel(fileName.split(".")[0],bitmap))
                }
            }
        } catch (e: IOException) {
            Log.i("assets",e.toString())
        }
        return category
    }

    fun fakeItems(context: Context , dir_name : String) : ArrayList<ItemsModel>{
        var items : ArrayList<ItemsModel> = arrayListOf()

        val list: Array<String>
        try {
            list = context.assets.list(dir_name) as Array<String>
            if (list.isNotEmpty()) {
                for (fileName in list) {
                    val istr: InputStream = context.assets.open("$dir_name/$fileName")
                    val bitmap = BitmapFactory.decodeStream(istr)
                    items.add(ItemsModel(fileName.split(".")[0],bitmap))
                }
            }
        } catch (e: IOException) {
            Log.i("assets",e.toString())
        }
        return items
    }

    companion object{
        val data : ArrayList<WishListItemModel> = arrayListOf(
            WishListItemModel("k","20 qar",23,null,null,false),
            WishListItemModel("k","20 qar",23,null,"EXCLUSIVE",true),
            WishListItemModel("k","20 qar",23,null,"PRE-ORDER",false)
        )

        val pastNotificationData : ArrayList<PastNotificationModel> = arrayListOf(
            PastNotificationModel("1st","1st Notification"),
            PastNotificationModel("2nd","2nd Notification"),
            PastNotificationModel("3rd","3rd Notification"),
            PastNotificationModel("4th","4th Notification")
        )

        var cards : ArrayList<DebitCardModel> = arrayListOf(
            DebitCardModel("5454 5412 8552 5856" , "dfdfdg" , "12/2/2022","684"),
            DebitCardModel("8484 5623 8563 5233" , "dfdfdg" , "12/2/2022","684"),
            DebitCardModel("9652 6333 5526 5853" , "dfdfdg" , "12/2/2022","684")
        )

        var transactions : ArrayList<TransactionModel> = arrayListOf(
            TransactionModel("358056182",-500,3,2520,2251,"1 Jan 2020","10:29"),
            TransactionModel("358056182",+500,3,2520,2251,"1 Jan 2020","10:29"),
            TransactionModel("358056182",-500,3,2520,2251,"1 Jan 2020","10:29")
        )
    }

}