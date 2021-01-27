package com.example.rivenlee.kotlin_learn_diary.project.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rivenlee.kotlin_learn_diary.R
import kotlinx.android.synthetic.main.activity_progress.*
import org.jetbrains.anko.toast

class ProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        tv_wrapper.setOnClickListener {
            doWrapper()
        }
    }

    fun funa(func: (msg: String)-> Unit){

        fun b(){
            toast("this is funb")
            func("this is func")
        }
        return b()
    }


    private fun func(msg: String){
        toast("this is fun -> $msg")
    }

    private val valc = fun(msg: String) {
        toast("this is val -> $msg")
    }

    private fun doWrapper(){
        funa(::func)
    }

}