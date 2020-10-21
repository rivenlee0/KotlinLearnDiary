package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.rivenlee.kotlin_learn_diary.R
import kotlin.math.*

/**
 * FileName: MeasureView
 * Author: rivenLee
 * Date: 2020/10/15 15:21
 */
class MeasureView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paint3 = Paint(Paint.ANTI_ALIAS_FLAG)
    private var rectF: RectF? = null
    private var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
    private var path: Path? = null

    init {
        initPaint()
        initRect()
        initPath()
    }

    private fun initPaint() {
        paint.color = resources.getColor(R.color.Yellow)
        paint1.color = resources.getColor(R.color.Blue)
        paint2.color = resources.getColor(R.color.White)
        paint2.textSize = 90f
        paint3.color = resources.getColor(R.color.Red)
    }

    private fun initRect() {
        val left = left.toFloat()
        val top = top.toFloat()
        val right = right.toFloat()
        val bottom = bottom.toFloat()
        rectF = RectF(left, top, right, bottom)
    }

    private fun initPath() {
        path = Path()
        val floats = fivePoints(100f, 100f, 100)
        var i = 0
        while (i < floats.size - 1) {
            path?.lineTo(floats[i], floats[0.let { i += it; i }])
            i++
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawRect(left.toFloat(), top, right, bottom, paint)
        val radius = width.coerceAtMost(height) / 4.toFloat()
//        canvas?.drawCircle(width/2.toFloat(),height/2.toFloat(), radius, paint)
//        canvas?.drawArc(rectF, 0F, 60F, false, paint)
//        canvas?.drawArc(rectF, 60F, 30F, true, paint1)
        val bitmapWidth = (width - bitmap.width) / 2.toFloat()
        val bitmapHeight = (height - bitmap.height) / 2.toFloat()
        val text = "Android"
        val textWidth = (width - paint2.measureText(text)) / 2.toFloat()
        val fontMetrics = paint2.fontMetrics
        val textHeight = (height + (abs(fontMetrics.ascent) - abs(fontMetrics.descent)) + bitmapHeight) / 2.toFloat()
        canvas?.drawBitmap(bitmap, bitmapWidth, bitmapHeight, paint)
        canvas?.drawText(text, textWidth, textHeight, paint2)
        canvas?.drawPath(path, paint3)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(measuredWidth(widthMeasureSpec), measuredWidth(heightMeasureSpec))
    }

    /**
     * 加入了利用MeasureSpec来判断模式。根据不同模式，进行对宽高赋值。在AT_MOST也就是wrap_content时，默认最大的宽高都是200px
     */
    private fun measuredWidth(widthMeasureSpec: Int): Int {
        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        val specSize = MeasureSpec.getSize(widthMeasureSpec)
        return when (specMode) {
            MeasureSpec.EXACTLY -> specSize
            MeasureSpec.AT_MOST -> 200.coerceAtMost(specSize)
            else -> 200
        }
    }

    private fun fivePoints(xA: Float, yA: Float, rFive: Int): FloatArray {
        var xB = 0f
        var xC = 0f
        var xD = 0f
        var xE = 0f
        var yB = 0f
        var yC = 0f
        var yD = 0f
        var yE = 0f
        xD = (xA - rFive * sin(Math.toRadians(18.0))).toFloat()
        xC = (xA + rFive * sin(Math.toRadians(18.0))).toFloat()
        yC = (yA + cos(Math.toRadians(18.0)) * rFive).toFloat()
        yD = yC
        yE = (yA + sqrt((xC - xD).toDouble().pow(2.0) - (rFive / 2).toDouble().pow(2.0))).toFloat()
        yB = yE
        xB = xA + rFive / 2
        xE = xA - rFive / 2
        return floatArrayOf(xA, yA, xD, yD, xB, yB, xE, yE, xC, yC, xA, yA)
    }

}