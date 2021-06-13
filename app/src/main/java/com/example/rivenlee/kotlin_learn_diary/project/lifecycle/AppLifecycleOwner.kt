package com.example.rivenlee.kotlin_learn_diary.project.lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

/**
 * FileName: AppLifecycleOwner
 * Author: rivenLee
 * Date: 2020/9/10 15:17
 */
class AppLifecycleOwner : LifecycleOwner{
    private val registry = LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle = registry
    private var count = 0

    fun init(app: Application){
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks{
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            }

            override fun onActivityStarted(activity: Activity) {
                if (count == 0) {
                    registry.handleLifecycleEvent(Lifecycle.Event.ON_START)
                }
                count++
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
                count--
                if (count == 0) {
                    registry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
                }
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }
        })
    }

}