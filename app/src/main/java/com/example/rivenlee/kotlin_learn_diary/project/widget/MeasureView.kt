package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * FileName: MeasureView
 * Author: rivenLee
 * Date: 2020/10/15 15:21
 */
class MeasureView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    init {

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

}