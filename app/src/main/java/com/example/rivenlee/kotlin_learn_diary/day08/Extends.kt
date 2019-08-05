package com.example.rivenlee.kotlin_learn_diary.day08

import java.lang.StringBuilder

/**
 * author: rivenlee
 * date: 2019/8/5
 * email: rivenlee0@gmail.com
 */
fun main(args: Array<String>) {
    if (args.isEmpty()) {

    }
    println("abc".mul(16))
    println("abc" * 16)
}

//扩展方法
fun String.mul(int: Int): String{
    val stringBuilder = StringBuilder()
    for (i in 0 until int){
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

operator fun String.times(int: Int): String{
    val stringBuilder = StringBuilder()
    for (i in 0 until int){
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}
