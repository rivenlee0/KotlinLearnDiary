package com.example.rivenlee.kotlin_learn_diary.design_mode.proxy

/**
 * kotlin方式实现代理模式
 */

interface Base {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int): Base {
    override fun printMessage() = print(x)
    override fun printMessageLine() = print(x)
}

class Derived(b: Base): Base by b {
    override fun printMessageLine() = print("abc")
}

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    Derived(b).printMessage()
    Derived(b).printMessageLine()
}