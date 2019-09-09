package com.example.rivenlee.kotlin_learn_diary.day04

/**
 * author: rivenlee
 * date: 2018/11/29
 * email: rivenlee0@gmail.com
 */

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
    }

    for ((index, value) in args.withIndex()) {
        println("$index -> $value")
    }

    for (indexedValue in args.withIndex()) {
        println("${indexedValue.index} -> ${indexedValue.value}")
    }


    val array = intArrayOf(1, 3, 5, 7)
    // *array表示将当前数组展示，仅支持数组，不支持集合
    // string = "hello", 可变长参数之后的具名参数
    hello(3.0, *array, string = "hello")
}


fun hello(double: Double, vararg ints: Int, string: String) {
    ints.forEach(::println)
    println(string)
}
