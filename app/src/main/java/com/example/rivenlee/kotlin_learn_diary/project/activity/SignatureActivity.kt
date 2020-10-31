package com.example.rivenlee.kotlin_learn_diary.project.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rivenlee.kotlin_learn_diary.R
import kotlinx.android.synthetic.main.activity_signature.*
import org.jetbrains.anko.toast

class SignatureActivity : AppCompatActivity(R.layout.activity_signature) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tv_save.setOnClickListener {
            if (sign_view.save()) {
                toast("保存成功")
            } else {
                toast("保存失败")
            }
        }
    }

}