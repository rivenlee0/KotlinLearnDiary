package com.example.rivenlee.kotlin_learn_diary.project.lifecycle

import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.example.rivenlee.kotlin_learn_diary.APPContext

/**
 * FileName: AppLifecycleObserver
 * Author: rivenLee
 * Date: 2020/9/10 16:25
 */
class AppLifecycleObserver: LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> {
                Toast.makeText(APPContext, "Lifecycle_前台", Toast.LENGTH_SHORT).show()
            }
            Lifecycle.Event.ON_STOP -> {
                Toast.makeText(APPContext, "Lifecycle_后台", Toast.LENGTH_SHORT).show()
            }
            else -> {

            }
        }
    }

}