package com.example.rivenlee.kotlin_learn_diary.design_mode.observer

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

class TextView {
    var listener: TextChangedListener? = null
    var text: String by Delegates.observable("") { prop, oldText, newText ->
        listener?.onTextChanged(newText)
    }
}
