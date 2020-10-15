package com.example.rivenlee.kotlin_learn_diary.project.ext

import android.content.Context
import com.example.rivenlee.kotlin_learn_diary.APPContext
import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * FileName: PreferencesExt
 * Author: rivenLee
 * Date: 2020/9/27 10:57
 */

class Preferences<T>(val key: String, val default: T, val prefName: String = "default"): ReadWriteProperty<Any?, T> {

    private val prefs by lazy {
        APPContext.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        with(prefs.edit()) {
            when (value) {
                is Int -> putInt(key, value)
                is Long -> putLong(key, value)
                is String -> putString(key, value)
                is Boolean -> putBoolean(key, value)
                else -> throw IllegalArgumentException()
            }
        }.commit()
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return when (default) {
            is Int -> prefs.getInt(key, default)
            is Long -> prefs.getLong(key, default)
            is String -> prefs.getString(key, default)
            is Boolean -> prefs.getBoolean(key, default)
            else -> throw IllegalArgumentException()
        } as T
    }
}