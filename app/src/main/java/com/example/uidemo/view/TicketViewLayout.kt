package com.example.uidemo.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.uidemo.R
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
    private lateinit var canvas: Canvas

    init {
        eraser.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
        eraser.isAntiAlias = true
        eraser.color = Color.TRANSPARENT
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        if (h != oldh || w != oldw){
            val r = min(h,w)
            holeRadius = (r/15).toFloat()

            bitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
            canvas = Canvas(bitmap)

        }
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
//        canvas.drawCircle(0F , height - pxFromDp(context, holesBottomMargin),holeRadius,eraser)
//        canvas.drawCircle(width.toFloat(), height - pxFromDp(context, holesBottomMargin),holeRadius,eraser)


        val w = width
        val h = height
        bitmap.eraseColor(Color.TRANSPARENT)
        canvas.drawCircle(0F, h - pxFromDp(context, holesBottomMargin), holeRadius, eraser)
        canvas.drawCircle(w.toFloat(), h - pxFromDp(context, holesBottomMargin), holeRadius, eraser)
        canvas.drawBitmap(bitmap, 0F, 0F, null);

    }




    private fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }


}