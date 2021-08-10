package com.example.rivenlee.kotlin_learn_diary.project.ext

import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

/**
 * @Description: ViewBinding扩展类
 * @Author: rivenlee
 * @Date: 2021/7/28 16:34
 *
 * Example:
 * private val binding: ActivityMainBinding by inflate()
 */

inline fun <reified VB: ViewBinding> Activity.inflate() = lazy {
    inflateBinding<VB>(layoutInflater).apply { setContentView(root) }
}

inline fun <reified VB : ViewBinding> Dialog.inflate() = lazy {
    inflateBinding<VB>(layoutInflater).apply { setContentView(root) }
}

inline fun <reified VB: ViewBinding> inflateBinding(layoutInflater: LayoutInflater) =
    VB::class.java.getMethod("inflate", LayoutInflater::class.java).invoke(null, layoutInflater) as VB