package com.example.rivenlee.kotlin_learn_diary.project.activity

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.ViewConfiguration
import androidx.appcompat.app.AppCompatActivity
import com.example.rivenlee.kotlin_learn_diary.APPContext
import com.example.rivenlee.kotlin_learn_diary.R

/**
 * FileName: VelocityTrackerActivity
 * Author: rivenLee
 * Date: 2020/10/31 16:10
 */

class VelocityTrackerActivity : AppCompatActivity(R.layout.activity_velocity_tracker){

    private var velocityTracker: VelocityTracker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TouchSlop最小距离
        //TouchSlop是系统识别最小的滑动距离，是一个常量值。当手指在屏幕滑动距离小于这个值时，系统不会将动作视为滑动。
        //这个常量值的具体大小和设备也有关，不同的屏幕分辨率，可能会不一样
        //利用这个临界值，可以将一些不想要的手指操作给过滤掉
        ViewConfiguration.get(APPContext).scaledTouchSlop
        velocityTracker = VelocityTracker.obtain()
    }

    /**
     * x轴速度，从左向右滑动时，速度为正，从右向左滑动为负；
     * y轴速度，从上向下滑动时，速度为正，从下向上滑动为负；
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        velocityTracker?.addMovement(event)
        velocityTracker?.computeCurrentVelocity(1000)
        val x = velocityTracker?.xVelocity
        val y = velocityTracker?.yVelocity
        Log.e("TAG", "&&&-->x = $x---> y = $y")
        return super.onTouchEvent(event)
    }

    override fun onDestroy() {
        super.onDestroy()
        velocityTracker?.clear()
        velocityTracker?.recycle()
    }
}