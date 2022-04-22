package com.example.uidemo.utils

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import com.example.uidemo.model.CategoryModel
import com.example.uidemo.model.ItemsModel
import com.example.uidemo.model.WishListItemModel
import java.io.IOException
import java.io.InputStream


class FakeData {

    fun fakeCategories(context: Context , dir_name : String) : ArrayList<CategoryModel>{
        var category : ArrayList<CategoryModel> = arrayListOf()

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
    }

}