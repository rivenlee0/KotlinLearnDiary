package com.example.rivenlee.kotlin_learn_diary.day15

import java.io.OutputStream

/**
 * author: rivenlee
 * date: 2019/9/9
 * email: rivenlee0@gmail.com
 * 柯里化
 */

fun log(tag: String, target: OutputStream, message: Any?){
    target.write("[$tag] $message\n".toByteArray())
}

/**
 * 柯里化函数
 */
fun logCurried(tag: String)
    = fun(target: OutputStream)
    = fun(message: Any?)
    = target.write("[$tag] $message\n".toByteArray())


fun main(args: Array<String>) {
    log("riven", System.out, "Hello World")
    logCurried("riven")(System.out)("Hell World Curry")
    ::log.curried()("riven")(System.out)("Hell World Curry!!!")
}

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried()
    = fun(p1: P1) = fun (p2: P2) = fun(p3: P3) = this(p1,p2,p3)


