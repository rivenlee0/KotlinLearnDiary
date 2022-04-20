package com.example.rivenlee.kotlin_learn_diary.project.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.project.activity.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {

    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_table.setOnClickListener(this)
        tv_custom.setOnClickListener(this)
        tv_scratch.setOnClickListener(this)
        tv_web.setOnClickListener(this)
        tv_canvas.setOnClickListener(this)
        tv_signature.setOnClickListener(this)
        tv_velocity_tracker.setOnClickListener(this)
        tv_scroller.setOnClickListener(this)
        tv_view_drag_helper.setOnClickListener(this)
        tv_progress.setOnClickListener(this)
        tv_goods_search.setOnClickListener(this)
        tv_motion.setOnClickListener(this)
        tv_seek.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_table -> startAct(TableActivity::class.java)
            R.id.tv_custom -> startAct(CustomActivity::class.java)
            R.id.tv_scratch -> startAct(ScratchCardActivity::class.java)
            R.id.tv_web -> startAct(WebActivity::class.java)
            R.id.tv_canvas -> startAct(CanvasActivity::class.java)
            R.id.tv_signature -> startAct(SignatureActivity::class.java)
            R.id.tv_velocity_tracker -> startAct(VelocityTrackerActivity::class.java)
            R.id.tv_scroller -> startAct(ScrollerActivity::class.java)
            R.id.tv_view_drag_helper -> startAct(ViewDragActivity::class.java)
            R.id.tv_progress -> startAct(ProgressActivity::class.java)
            R.id.tv_goods_search -> startAct(GoodsBindListActivity::class.java)
            R.id.tv_motion -> startAct(MotionActivity::class.java)
            R.id.tv_seek -> startAct(SeekActivity::class.java)
        }
    }

    private inline fun <reified T> startAct(clz: Class<T>) {
        context?.let {
            startActivity(Intent(it, clz))
        }
    }
}