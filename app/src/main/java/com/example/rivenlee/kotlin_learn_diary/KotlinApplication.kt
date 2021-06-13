package com.example.rivenlee.kotlin_learn_diary

import android.app.Activity
import android.app.Application
import android.content.ContextWrapper
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

private lateinit var INSTANCE: Application
private val TAG = "KotlinLearnDiary"

@HiltAndroidApp
class KotlinApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
    }

    private var mActivityLifecycleCallbacks = object : ActivityLifecycleCallbacks{
        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityResumed(activity: Activity) {
        }

        override fun onActivityStarted(activity: Activity) {
            Log.d(TAG, "onStart -> " + activity.componentName.className)

        }

        override fun onActivityDestroyed(activity: Activity) {
            Log.d(TAG, "onDestroy -> " + activity.componentName.className)
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Log.d(TAG, "onCreated -> " + activity.componentName.className)
        }
    }
}

object APPContext: ContextWrapper(INSTANCE)