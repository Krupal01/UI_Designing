package com.example.uidemo.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.LinearLayout


class TicketView : LinearLayout {

    private val bm: Bitmap? = null
    private val cv: Canvas? = null
    private var eraser: Paint? = null
    private val holesBottomMargin = 70
    private val holeRadius = 40

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }

    fun init(){
        eraser = Paint()
        eraser!!.setXfermode(PorterDuffXfermode(PorterDuff.Mode.CLEAR))
        eraser!!.setAntiAlias(true)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {

        val w = width
        val h = height

        bm?.eraseColor(Color.TRANSPARENT)

        cv!!.drawColor(Color.WHITE)

        val paint = Paint()
        paint.setARGB(255, 250, 250, 250)
        paint.setStrokeWidth(0F)
        paint.style = Paint.Style.FILL
        cv.drawRect(0f, h.toFloat(), w.toFloat(), h - pxFromDp(context, holesBottomMargin.toFloat()), paint)

        cv.drawCircle(0F, 0F, holeRadius.toFloat(), eraser!!); // top-left hole
        cv.drawCircle((w / 2).toFloat(), 0F, holeRadius.toFloat(), eraser!!); // top-middle hole
        cv.drawCircle(w.toFloat(), 0F, holeRadius.toFloat(), eraser!!); // top-right
        cv.drawCircle(0F, h - pxFromDp(getContext(), holesBottomMargin.toFloat()),
            holeRadius.toFloat(), eraser!!); // bottom-left hole
        cv.drawCircle(w.toFloat(), h - pxFromDp(getContext(), holesBottomMargin.toFloat()),
            holeRadius.toFloat(), eraser!!); // bottom right hole

        canvas?.drawBitmap(bm!!, 0F, 0F, null)


        // drawing dashed lines at the bottom


        // drawing dashed lines at the bottom
        val mPath = Path()
        mPath.moveTo(holeRadius.toFloat(), h - pxFromDp(context, holesBottomMargin.toFloat()))
        mPath.quadTo(
            (w - holeRadius).toFloat(), h - pxFromDp(context, holesBottomMargin.toFloat()),
            (w - holeRadius).toFloat(), h - pxFromDp(
                context,
                holesBottomMargin.toFloat()
            )
        )

        // dashed line

        // dashed line
        val dashed = Paint()
        dashed.setARGB(255, 200, 200, 200)
        dashed.style = Paint.Style.STROKE
        dashed.setStrokeWidth(2F)
        dashed.pathEffect = DashPathEffect(floatArrayOf(10f, 5f), 0F)
        canvas!!.drawPath(mPath, dashed)

        super.onDraw(canvas)
    }

    fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }
}