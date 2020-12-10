package com.example.rivenlee.kotlin_learn_diary.design_mode.observer

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.properties.Delegates

/**
 * FileName: Observer
 * Author: rivenLee
 * Date: 2020/8/25 16:42
 * 观察者模式
 * 具体实现方式见 project/activity/TableActivity.kt
 */
interface TextChangedListener {
    fun onTextChanged(newText: String)
}


@Singleton
class TextView @Inject constructor() {
    var listener: TextChangedListener? = null
    var text: String by Delegates.observable("") { prop, oldText, newText ->
        listener?.onTextChanged(newText)
    }
}
