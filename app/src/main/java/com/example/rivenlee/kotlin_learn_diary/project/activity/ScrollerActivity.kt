package com.example.rivenlee.kotlin_learn_diary.project.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import com.example.rivenlee.kotlin_learn_diary.R
import org.jetbrains.anko.toast

class ScrollerActivity : AppCompatActivity(R.layout.activity_scroller) {

    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initGestureDetector()
    }

    private fun initGestureDetector() {
        /**
         * 在OnGestureListener内onDown(),onSingleTapUp(),onScroll(),onFling()方法都有一个boolean类型的返回值，
         * 这个值表示是否消费事件
         */
        gestureDetector = GestureDetector(this, object : GestureDetector.OnGestureListener {
            override fun onDown(e: MotionEvent?): Boolean {
                //手指轻触屏幕的一瞬间，由一个ACTION_DOWN触发
                toast("轻触一下")
                return true
            }

            override fun onShowPress(e: MotionEvent?) {
                //手指轻触屏幕，尚未松开或拖动，由一个ACTION_DOWN触发
                toast("轻触未松开")
            }

            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                //手指离开屏幕，伴随一个ACTION_UP触发，单击行为
                toast("单击")
                return true
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
                //由一个ACTION_DOWN，多个ACTION_MOVE触发，是拖动行为
                toast("拖动")
                return false
            }

            override fun onLongPress(e: MotionEvent?) {
                //长按
                toast("长按")
            }

            override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
                //按下屏幕，快速滑动后松开，由一个ACTION_DOWN，多个ACTION_MOVE，一个ACTION_UP触发
                toast("快速滑动")
                return false
            }
        })

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean = gestureDetector.onTouchEvent(event)
}