package com.example.rivenlee.kotlin_learn_diary.day03

/**
 * author: rivenlee
 * date: 2018/11/8
 * email: rivenlee0@gmail.com
 */


fun main(args: Array<String>){

    val x = 5
    when (x) {
        is Int -> println("Hello, $x")
        in 1..100 -> println("$x is in 1..100")
        !in 1..100 -> println("$x is not in 1..100")
        else -> {
            //else相当于default
        }
    }

    val mode = when {
        x is Int -> 1
        else -> 0
    }
}