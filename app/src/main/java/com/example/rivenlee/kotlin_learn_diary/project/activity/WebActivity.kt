package com.example.rivenlee.kotlin_learn_diary.project.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rivenlee.kotlin_learn_diary.R
import kotlinx.android.synthetic.main.activity_web.*

/**
 * FileName: WebActivity
 * Author: rivenLee
 * Date: 2020/10/28 14:22
 */

class WebActivity : AppCompatActivity(R.layout.activity_web){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        web_view.settings.userAgentString = web_view.settings.userAgentString + "/bxsc/android/1.1.5"
        web_view.settings.javaScriptEnabled = true
        web_view.loadUrl("https://oss.tanleizhen.com/static/xieyi/schyxy.html")
    }
}