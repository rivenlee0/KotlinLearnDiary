package com.example.rivenlee.kotlin_learn_diary.day12

/**
 * author: rivenlee
 * date: 2019/9/3
 * email: rivenlee0@gmail.com
 */

fun main(args: Array<String>) {

    val numList = listOf(1, 2, 3, 4, 5)
    val newList = numList.map { it * 2 + 3 }
    newList.forEach(::println)

    val newList2 = newList.map(Int::toDouble)
    newList2.forEach(::println)


    val list = listOf(
            1..20,
            2..5,
            10..32
    )

    val flatMap = list.flatMap {intRange ->
        intRange.map { intElement ->
            "No.$intElement"
        }
    }
    flatMap.forEach(::println)

    val reduce = flatMap.reduce { acc, s -> acc + s }
    println(reduce)

    //字符串拼接
    println((0..20).joinToString(","))
    //符合条件后，保留之前数据，不再继续执行
    (0..6).map(::factorial).takeWhile{ it % 2 == 1 }
}

/**
 * 阶乘函数
 */
fun factorial(n: Int): Int{
    if (n == 0) return 1
    return (1..n).reduce { acc, i -> acc * i }
}