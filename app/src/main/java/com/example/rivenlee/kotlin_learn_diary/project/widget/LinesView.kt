package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * FileName: CanvasView
 * Author: rivenLee
 * Date: 2020/10/29 15:49
 */
class LinesView (context: Context?, attrs: AttributeSet?): View(context, attrs) {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val linesList: MutableList<FloatArray> = mutableListOf()

    init {
        paint.color = Color.BLUE
        paint.strokeWidth = 15f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(startX, startY, stopX, stopY, paint)
        for (floats in linesList) {
            canvas?.drawLine(floats[0], floats[1], floats[2], floats[3], paint)
        }
        postInvalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                stopX = event.x
                stopY = event.y
                postInvalidate()
            }
            MotionEvent.ACTION_UP -> {
                linesList.add(floatArrayOf(startX, startY, stopX, stopY))
                postInvalidate()
            }
            else -> {
            }

        }
        return true
    }
    private var startX:Float = 0f
    private var startY:Float = 0f
    private var stopX:Float = 0f
    private var stopY:Float = 0f

}