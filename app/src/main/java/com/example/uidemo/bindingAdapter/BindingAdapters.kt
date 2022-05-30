package com.example.uidemo.bindingAdapter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.uidemo.R
import com.example.uidemo.utils.FakeData


@BindingAdapter("android:setBitmap")
fun setBitmap(view: ImageView , bitmap: Bitmap?){
    if(bitmap != null){
        view.setImageBitmap(bitmap)
    }else{
        view.setImageResource(R.drawable.ic_baseline_crop_original_24)
    }
}

@BindingAdapter("android:ResourceId")
fun setResourceId(view: ImageView , id: Int?){
    if(id != null){
        view.setImageResource(id)
    }else{
        view.setImageResource(R.drawable.ic_baseline_crop_original_24)
    }
}

@BindingAdapter("android:SetQuantity")
fun SetQuantity(view: TextView , quantity: Int?){
    if(quantity != null){
        if (quantity>12){
            view.text = view.context.resources.getString(R.string._12)
        }else{
            view.text = quantity.toString()
        }
    }else{
        view.text = "0"
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("android:SetDebitCardNumber")
fun SetDebitCardNumber(view: TextView , number : String?){
    if(number != null){
        view.text = "**** **** **** "+ number.split(" ").last()
    }else{
        view.text = "0"
    }
}


@SuppressLint("SetTextI18n")
@BindingAdapter("android:setCardLogo")
fun setCardLogo(view: ImageView,cardType : String){
    when (cardType){
        FakeData.VISA -> {
            view.setImageResource(R.drawable.icons8_visa_24)
        }
        FakeData.MASTER -> {
            view.setImageResource(R.drawable.icons8_mastercard_logo_48)
        }
    }
}


