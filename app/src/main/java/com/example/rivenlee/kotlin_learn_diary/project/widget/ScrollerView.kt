package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.Scroller

/**
 * 用于实现View的弹性滑动。Scroller本身无法实现弹性滑动，需要配合View的computeScroll()方法
 * Scroller使用有个固定的3步走模式：
 * 初始化Scroller对象
 * 重写View的computeScroll()方法
 * 调用mScroller.startScroll()方法
 */
class ScrollerView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val scroller = Scroller(context)


    override fun computeScroll() {
        //判断Scroller是否执行完毕
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.currX, scroller.currY)
            postInvalidate()
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean = true

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                smoothScrollTo(event.x, event.y)
            }
            MotionEvent.ACTION_UP -> {
                //恢复左上角
                scroller.startScroll(scrollX, scrollY, -scrollX, -scrollY)
            }
            else -> {
            }
        }
        return true
    }

    private fun smoothScrollTo(x: Float, y: Float) {
        val deltaX = scrollX - x
        val deltaY = scrollY - y
        scroller.startScroll(0, 0, deltaX.toInt(), deltaY.toInt(), 1000)
        postInvalidate()
    }
}