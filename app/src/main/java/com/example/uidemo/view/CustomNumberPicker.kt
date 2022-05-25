package com.example.uidemo.view

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.widget.addTextChangedListener
import com.example.uidemo.R


class CustomNumberPicker @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context,attrs, defStyleAttr) {

    private val TEXTVIEW_HEIGHT = 60
    private val TEXTVIEW_WIDTH = 60

    var value : Int = 0

    private val MINIMUM = 0
    private val MAXIMUM = 999

    var decrement: AppCompatImageButton? = null
    var increment: AppCompatImageButton? = null
    var valueText: EditText? = null

    init {
        this.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
        this.gravity = Gravity.CENTER_VERTICAL
        val btnParam = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
        val textViewParam = LayoutParams(TEXTVIEW_WIDTH,TEXTVIEW_HEIGHT)
        initDecrementButton( context )
        initValueEditText( context )
        initIncrementButton( context )
        if( orientation == VERTICAL ){
            addView( increment, btnParam )
            addView( valueText, textViewParam )
            addView( decrement, btnParam )
        } else {
            addView( decrement, btnParam )
            addView( valueText, textViewParam )
            addView( increment, btnParam )
        }
    }

    private fun initIncrementButton(context: Context) {
        increment = AppCompatImageButton(context)
        increment!!.setImageResource(R.drawable.ic_baseline_add_24)
        increment!!.setBackgroundResource(android.R.color.transparent)
        increment!!.scaleX=0.7f
        increment!!.scaleY=0.7f
        increment!!.setOnClickListener { increment() }

    }
    private fun initDecrementButton(context: Context) {
        decrement = AppCompatImageButton(context)
        decrement!!.setImageResource(R.drawable.ic_baseline_remove_24)
        decrement!!.setBackgroundResource(android.R.color.transparent)
        decrement!!.scaleX=0.7f
        decrement!!.scaleY=0.7f
        decrement!!.setOnClickListener { decrement() }
    }
    private fun initValueEditText(context: Context) {
        value = 0
        valueText =  EditText( context )
        valueText!!.gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL
        valueText!!.setText(value.toString())
        valueText!!.inputType = InputType.TYPE_CLASS_NUMBER
        valueText!!.setBackgroundResource(android.R.color.transparent)

        valueText!!.addTextChangedListener {

        }

    }

    private fun increment() {
        if (value < MAXIMUM) {
            value += 1
            valueText!!.setText(value.toString())
        }
    }

    private fun decrement() {
        if (value > MINIMUM) {
            value -= 1
            valueText!!.setText(value.toString())
        }
    }

    @JvmName("getValue1")
    fun getValue(): Int {
        return value
    }

    @JvmName("setValue1")
    fun setValue(value: Int) {
        var value = value
        if (value > MAXIMUM) value = MAXIMUM
        if (value >= 0) {
            this.value = value
            valueText!!.setText(this.value.toString())
        }
    }

}