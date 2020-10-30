package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

/**
 * FileName: SignatureView
 * Author: rivenLee
 * Date: 2020/10/30 16:39
 */
class SignatureView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path: Path = Path()
    private var bitmap: Bitmap? = null
    private var canvas: Canvas? = null
    private var lastX = 0f
    private var lastY = 0f

    init {
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
        paint.color = Color.CYAN
        //使画笔两端更加圆润
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND

        post {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888).apply {
                canvas = Canvas(this)
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawColor(Color.BLACK)
        bitmap?.let {
            drawSignaturePath()
            canvas?.drawBitmap(it, 0f, 0f, null)
        }
    }

    /**
     * 绘制签名
     */
    private fun drawSignaturePath() {
        canvas?.drawPath(path, paint)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
                path.moveTo(lastX, lastY)
            }
            MotionEvent.ACTION_MOVE -> {
                if (abs(x - lastX) >= 3 || abs(y - lastY) >= 3){
                    //设置贝塞尔曲线的操作点为起点和终点的一半
                    //二次贝塞尔，实现平滑曲线；lastX, lastY，endX, endY
                    val endX = (lastX + x) /2
                    val endY = (lastY + y) /2
                    path.quadTo(lastX, lastY, endX, endY)
                }
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_UP -> {
                path.reset()
            }
        }
        postInvalidate()
        return true
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(measuredWidth(widthMeasureSpec), measuredWidth(heightMeasureSpec))
    }


    private fun measuredWidth(widthMeasureSpec: Int): Int {
        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        val specSize = MeasureSpec.getSize(widthMeasureSpec)
        return when (specMode) {
            MeasureSpec.EXACTLY -> specSize
            MeasureSpec.AT_MOST -> 400.coerceAtMost(specSize)
            else -> 400
        }
    }
}