package com.example.rivenlee.kotlin_learn_diary.day14

/**
 * author: rivenlee
 * date: 2019/9/6
 * email: rivenlee0@gmail.com
 */

val string = "HelloWorld"

fun makeFun(): () -> Unit {

    var count = 0
    return fun() {
        println(++count)
    }
}

fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return fun(): Long {
        val result = second
        second += first
        first = second - first
        return result
    }
}

fun fibonacci2(): Iterable<Long> {
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator() {
            override fun hasNext() = true

            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }
        }
    }
}


fun main(args: Array<String>) {
    val x = fibonacci()
    for (index in 1 until 11) {
        println(x())
    }

    for (index in fibonacci2()) {
        if (index > 100) break
        println(x())
    }
}

fun add(x :Int) = fun(y :Int) = x + y

fun add1(x: Int): (Int) -> Int{
    return fun (y: Int):Int{
        return x + y
    }
}

