package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * FileName: PorterDuffView
 * Author: rivenLee
 * Date: 2020/10/16 13:30
 */
class PorterDuffView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private lateinit var paint: Paint
    private lateinit var rectF: RectF
    private lateinit var porterDuffXfermode: PorterDuffXfermode

    init {
        initPaint()
    }

    private fun initPaint() {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        rectF = RectF(150f, 150f, 500f, 500f)
        porterDuffXfermode = PorterDuffXfermode(PorterDuff.Mode.MULTIPLY)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.YELLOW)
        //创建一个新的画布Layer
        val layerId = canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        //绘制dst层
        val x = width / 4
        val y = height / 4
        val radius = width.coerceAtMost(height) / 4
        paint.color = Color.CYAN
        canvas.drawCircle(x.toFloat(), y.toFloat(), radius.toFloat(), paint)
        //设置混合模式
        paint.color = Color.RED
        paint.xfermode = porterDuffXfermode
        //绘制src层
        canvas.drawRect(rectF, paint)
        paint.xfermode = null
        //将自己创建的画布Layer绘制到画布默认的Layer
        canvas.restoreToCount(layerId)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(resetMeasured(widthMeasureSpec), resetMeasured(widthMeasureSpec))
    }

    private fun resetMeasured(widthMeasureSpec: Int): Int {
        val size = MeasureSpec.getSize(widthMeasureSpec)
        return when (MeasureSpec.getMode(widthMeasureSpec)) {
            MeasureSpec.EXACTLY -> size
            MeasureSpec.AT_MOST -> 600.coerceAtMost(size)
            else -> 600
        }
    }

}