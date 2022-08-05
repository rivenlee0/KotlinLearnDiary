package com.example.rivenlee.kotlin_learn_diary.project.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Consumer
import androidx.window.FoldingFeature
import androidx.window.WindowLayoutInfo
import androidx.window.WindowManager
import com.example.rivenlee.kotlin_learn_diary.R
import kotlinx.android.synthetic.main.activity_fold.*
import org.jetbrains.anko.toast
import java.util.concurrent.Executor

/**
 * @name： KotlinLearnDiary
 * @author： rivenlee
 * @time： 2022/7/14 4:23 下午
 * @description：
 */
class FoldActivity: AppCompatActivity(R.layout.activity_fold) {


    private lateinit var windowManager: WindowManager
    private val handle = Handler(Looper.getMainLooper())
    private val mainThreadExecutor = Executor { r: Runnable -> handle.post(r) }

    private val stateContainer = StateContainer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        windowManager = WindowManager(this)

    }

    override fun onStart() {
        super.onStart()
        windowManager.registerLayoutChangeCallback(mainThreadExecutor, stateContainer)
    }

    override fun onStop() {
        super.onStop()
        windowManager.unregisterLayoutChangeCallback(stateContainer)
    }

    inner class StateContainer: Consumer<WindowLayoutInfo> {
        var lastLayoutInfo: WindowLayoutInfo? = null
        override fun accept(newLayoutInfo: WindowLayoutInfo) {
            for (displayFeature in newLayoutInfo.displayFeatures) {
                val foldFeature = displayFeature as? FoldingFeature
                foldFeature?: continue
                if (foldFeature.isSeparating) {
                    toast("半展开")
                    text.text = "折叠屏半展开"
                } else {
                    toast("完全展开")
                    text.text = "折叠屏完全展开"
                }
            }
        }
    }
}