package com.example.rivenlee.kotlin_learn_diary

import android.app.Application

class APP : Application() {

    companion object {
        lateinit var instance: Application
    }
    override fun onCreate() {
        super.onCreate()
        instance = this

    }
}