package com.example.uidemo.view

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.uidemo.R

class GenericTextWatcher constructor(private val currentView: View, private val nextView: View?) :
    TextWatcher {
    override fun afterTextChanged(editable: Editable) { // TODO Auto-generated method stub
        val text = editable.toString()
        when (currentView.id) {
            R.id.otpEt1 -> if (text.length == 1) nextView!!.requestFocus()
            R.id.otpEt2 -> if (text.length == 1) nextView!!.requestFocus()
            R.id.otpEt3 -> if (text.length == 1) nextView!!.requestFocus()
        }
    }

    override fun beforeTextChanged(
        arg0: CharSequence,
        arg1: Int,
        arg2: Int,
        arg3: Int
    ) { // TODO Auto-generated method stub
    }

    override fun onTextChanged(
        arg0: CharSequence,
        arg1: Int,
        arg2: Int,
        arg3: Int
    ) { // TODO Auto-generated method stub
    }

}