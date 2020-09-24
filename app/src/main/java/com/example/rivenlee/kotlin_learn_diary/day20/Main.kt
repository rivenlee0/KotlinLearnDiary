package com.example.rivenlee.kotlin_learn_diary.day20

/**
 * FileName: Main
 * Author: rivenLee
 * Date: 2020/9/23 16:47
 */

fun main() {
    val a = 2
    val b = 3
    val c = maxOf(a, b)
    println(c)
}

fun<T:Comparable<T>> maxOf(a: T, b: T): T {
    return if (a > b) a else b
}

inline fun<reified T> testGenerics(){
    println(T::class.java)
}