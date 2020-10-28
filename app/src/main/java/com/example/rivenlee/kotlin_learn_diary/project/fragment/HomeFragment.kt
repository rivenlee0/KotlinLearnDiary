package com.example.rivenlee.kotlin_learn_diary.project.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.project.activity.CustomActivity
import com.example.rivenlee.kotlin_learn_diary.project.activity.ScratchCardActivity
import com.example.rivenlee.kotlin_learn_diary.project.activity.TableActivity
import com.example.rivenlee.kotlin_learn_diary.project.activity.WebActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {

    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_table.setOnClickListener(this)
        tv_custom.setOnClickListener(this)
        tv_scratch.setOnClickListener(this)
        tv_web.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_table -> startActivity(Intent(context, TableActivity::class.java))
            R.id.tv_custom -> startActivity(Intent(context, CustomActivity::class.java))
            R.id.tv_scratch -> startActivity(Intent(context, ScratchCardActivity::class.java))
            R.id.tv_web -> startActivity(Intent(context, WebActivity::class.java))
        }
    }
}