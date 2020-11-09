package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.customview.widget.ViewDragHelper

/**
 * FileName: DragView
 * Author: rivenLee
 * Date: 2020/11/3 16:20
 */

class DragView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private lateinit var dragHelper: ViewDragHelper
    private lateinit var initPoint: Point

    init {
        dragHelper = ViewDragHelper.create(this, 1.0f, object : ViewDragHelper.Callback() {
            //可以用来指定哪一个childView可以拖动
            override fun tryCaptureView(child: View, pointerId: Int): Boolean = true

            //水平拖动
            override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
                val leftPadding = paddingLeft
                val rightPadding = width - child.width - paddingRight
                return left.coerceAtLeast(leftPadding).coerceAtMost(rightPadding)
            }

            //垂直拖动
            override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
                val topPadding = paddingTop
                val bottomPadding = height - child.height - paddingBottom
                return top.coerceAtLeast(topPadding).coerceAtMost(bottomPadding)
            }

            //拖动结束后
            override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
                super.onViewReleased(releasedChild, xvel, yvel)
                if (releasedChild == autoTextView && releasedChild.top < (height / 2)) {
                    //平滑移动
                    dragHelper.smoothSlideViewTo(releasedChild, initPoint.x, initPoint.y)
                    ViewCompat.postInvalidateOnAnimation(this@DragView)
                }
            }

            /**
             * 想要实现Button既可以点击又可以拖动，需要在ViewDragHelper.Callback mDragCallback重写两个方法
             */
            override fun getViewHorizontalDragRange(child: View): Int {
                return measuredWidth - child.measuredWidth
            }

            override fun getViewVerticalDragRange(child: View): Int {
                return measuredHeight - child.measuredHeight
            }

            override fun onEdgeDragStarted(edgeFlags: Int, pointerId: Int) {
                super.onEdgeDragStarted(edgeFlags, pointerId)
                autoTextView?.let { dragHelper.captureChildView(it, pointerId) }
            }
        })
        dragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_RIGHT)
        initPoint = Point()
    }

    override fun onInterceptHoverEvent(event: MotionEvent): Boolean = dragHelper.shouldInterceptTouchEvent(event)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        dragHelper.processTouchEvent(event)
        return true
    }

    override fun computeScroll() {
        super.computeScroll()
        //不停计算位置后，自动移动
         if (dragHelper.continueSettling(true)) {
             //重新绘制
             ViewCompat.postInvalidateOnAnimation(this@DragView)
         }
    }

    private var autoTextView :View? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        autoTextView = getChildAt(0)
    }

    /**
     * 利用onLayout()方法，拿到TextView起始点一开始的初始化坐标( initPoint.x,initPoint.y)，
     * 在onViewReleased()方法中，进行结束拖动后的处理
     */
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        initPoint.x = autoTextView?.left!!
        initPoint.y = autoTextView?.top!!
    }

}