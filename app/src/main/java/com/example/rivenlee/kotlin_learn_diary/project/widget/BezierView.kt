package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 *  Path类
 *  这个类封装了一些可以借助一元直线方程，二元曲线方程，立方曲线的方法来绘制一些较为复杂
 *  的组合形式的集合图形，绘制出来的风格则是根据画笔设置的[style]来决定，也可以剪切或者
 *  绘制一段在文字在路径上。
 *  Path中有很多[add]开头的方法。有两个重点方法是[quadTo]和[cubicTo]方法
 */
class BezierView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()

    private val paint1: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path1 = Path()

    init {
        paint.color = Color.BLUE
//        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        path.moveTo(100f, 100f)
        path.quadTo(200f, 200f, 900f, 100f)

        paint1.color = Color.RED
//        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 10f
        //二阶
        path1.moveTo(100f, 300f)
        //三阶
        path1.cubicTo(200f,200f,400f,400f,900f,200f);
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(path, paint)
        canvas?.drawPath(path1, paint)
    }


}