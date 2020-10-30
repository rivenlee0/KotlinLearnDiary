package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * FileName: DrawTextOnPathView
 * Author: rivenLee
 * Date: 2020/10/30 10:31
 */

class DrawTextOnPathView(context: Context?, attrs: AttributeSet?) : View(context, attrs){

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path: Path = Path()
    private val chars = charArrayOf('a','b','c','d','e')
    init {
        //路径画笔
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f

        //文字画笔
        textPaint.color = Color.RED
        textPaint.textSize = 60f

        //路径
        path.addOval(RectF(100f, 100f, 400f, 400f), Path.Direction.CW)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(path, paint)
        canvas?.drawTextOnPath(chars, 0, chars.size, path, 0f, 0f , textPaint)
//        canvas?.drawTextRun(chars, 0, chars.size, 0, chars.size, 100f, 100f, false, textPaint)
    }

}

