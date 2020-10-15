package com.example.rivenlee.kotlin_learn_diary.project.ext

/**
 * FileName: SPKtx
 * Author: rivenLee
 * Date: 2020/9/27 10:55
 */
object SPConfig {

    val string by Preferences("name", "")
    val boolean by Preferences("name", false)

}