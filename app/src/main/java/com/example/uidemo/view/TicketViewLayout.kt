package com.example.uidemo.view

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewTreeObserver
import android.widget.RelativeLayout
import com.example.uidemo.R
import com.google.android.material.shape.*
import kotlin.math.min


class TicketViewLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context,attrs, defStyleAttr) {

    private var eraser: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var holeRadius = 20F
    private val holesBottomMargin = 30F
    private lateinit var bitmap : Bitmap
    private lateinit var canvasTemp: Canvas


    init {
//        eraser.color = resources.getColor(android.R.color.transparent)
//        eraser.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        eraser.setColor(resources.getColor(R.color.gray))
        eraser.isAntiAlias = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        if (h != oldh || w != oldw){
            val r = min(h,w)
            holeRadius = (r/15).toFloat()
            bitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
            canvasTemp = Canvas(bitmap)
        }
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun dispatchDraw(canvas: Canvas) {

        canvas.drawCircle(0F , height - pxFromDp(context, holesBottomMargin),holeRadius,eraser)
        canvas.drawCircle(width.toFloat(), height - pxFromDp(context, holesBottomMargin),holeRadius,eraser)

//        this.setLayerType(View.LAYER_TYPE_SOFTWARE,null)
//        val w = width
//        val h = height
//        bitmap.eraseColor(Color.TRANSPARENT)
//        canvas.drawCircle(0F, h - pxFromDp(context, holesBottomMargin), holeRadius, eraser)
//        canvas.drawCircle(w.toFloat(), h - pxFromDp(context, holesBottomMargin), holeRadius, eraser)
//        canvas.drawBitmap(bitmap, 0F, 0F, null);
//
        super.dispatchDraw(canvas)
    }

    private fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

}