package com.example.rivenlee.kotlin_learn_diary.project.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.databinding.ActivityMotionBinding

/**
 * @Description: 类作用描述
 * @Author: rivenlee
 * @Date: 2021/7/2 17:37
 */
class MotionActivity: AppCompatActivity() {

    private lateinit var mBinding: ActivityMotionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMotionBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.imgMarioRun.setImageResource(R.drawable.img_mario_run)
    }

}