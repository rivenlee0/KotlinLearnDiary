package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.widget.ImageView

/**
 * FileName: CircleImageView
 * Author: rivenLee
 * Date: 2020/10/16 14:26
 */
@SuppressLint("AppCompatCustomView")
class CircleImageView(context: Context, attrs: AttributeSet?) : ImageView(context, attrs){
    private lateinit var paint: Paint
    private lateinit var porterDuffXfermode: PorterDuffXfermode

    init {
        initPaint()
    }

    private fun initPaint() {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        porterDuffXfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    }

    override fun onDraw(canvas: Canvas) {
        val bitmap = (drawable as BitmapDrawable).bitmap
        drawTargetBitmap(canvas, bitmap)
    }

    private fun drawTargetBitmap(canvas: Canvas, bitmap: Bitmap) {
        val layer = canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        //先绘制dst层
        val x = width / 2.toFloat()
        val y = height / 2.toFloat()
        val radius = width.coerceAtMost(height) / 2.toFloat()
        canvas.drawCircle(x, y, radius, paint)
        //设置混合模式
        paint.xfermode = porterDuffXfermode
        //绘制src层
        val f_x = width /2 - bitmap.width /2.toFloat()
        val f_y = height /2 - bitmap.height /2.toFloat()
        canvas.drawBitmap(bitmap, f_x, f_y, paint)
        //还原混合模式
        paint.xfermode = null
        //还原画布
        canvas.restoreToCount(layer)
    }
}