package com.example.rivenlee.kotlin_learn_diary

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.multidex.MultiDex
import kotlin.properties.Delegates

class APP : Application() {

    companion object {
        val TAG = "KotlinLearnDiary"
        lateinit var instance: Application
        var context: Context by Delegates.notNull()
            private set
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)

    }
    private var mActivityLifecycleCallbacks = object : ActivityLifecycleCallbacks{
        override fun onActivityPaused(activity: Activity?) {
        }

        override fun onActivityResumed(activity: Activity?) {
        }

        override fun onActivityStarted(activity: Activity?) {
            Log.d(TAG, "onStart -> " + activity?.componentName?.className)

        }

        override fun onActivityDestroyed(activity: Activity?) {
            Log.d(TAG, "onDestroy -> " + activity?.componentName?.className)
        }

        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        }

        override fun onActivityStopped(activity: Activity?) {
        }

        override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            Log.d(TAG, "onCreated -> " + activity?.componentName?.className)
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}