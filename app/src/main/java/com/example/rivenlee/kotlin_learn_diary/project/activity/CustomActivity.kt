package com.example.rivenlee.kotlin_learn_diary.project.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rivenlee.kotlin_learn_diary.R

class CustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)
    }
}