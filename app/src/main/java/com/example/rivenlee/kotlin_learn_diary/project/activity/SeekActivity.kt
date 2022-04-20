package com.example.rivenlee.kotlin_learn_diary.project.activity

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rivenlee.kotlin_learn_diary.R
import kotlinx.android.synthetic.main.activity_seek.*

/**
 * @name： KotlinLearnDiary
 * @author： rivenlee
 * @time： 2021/11/25 7:20 下午
 * @description：
 */
class SeekActivity : AppCompatActivity(R.layout.activity_seek) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animator = ValueAnimator().apply {
            duration = 2000L
        }

        animator.addUpdateListener {
            progressBar.progress = it.animatedValue as Int
        }
        btn_blue.setOnClickListener {
            animator.setIntValues(progressBar.progress, 75)
            animator.start()
        }
        btn_pink.setOnClickListener {
            animator.setIntValues(progressBar.progress, 25)
            animator.start()
        }
    }

}