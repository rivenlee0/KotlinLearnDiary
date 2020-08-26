package com.example.rivenlee.kotlin_learn_diary.design_mode.proxy

/**
 * kotlin方式实现代理模式
 * 1.只能实现对接口方法的代理，即Base类不能为抽象类。
 * 2.不方便对所有的代理方法进行统一处理。比如说在执行每个方法前都执行相同的逻辑，而java动态代理可以方便的实现这个功能。
 * 3.方法名称有冲突时，代理类方法优先级较高。
 * 4.编译期自动生成代理模式。不会影响运行效率。
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