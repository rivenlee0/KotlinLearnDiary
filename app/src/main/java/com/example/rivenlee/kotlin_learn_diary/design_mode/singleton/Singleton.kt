package com.example.rivenlee.kotlin_learn_diary.design_mode.singleton

/**
 * FileName: Singleton
 * Author: rivenLee
 * Date: 2020/8/25 15:33
 */

/**
 * 饿汉式
 * object修饰的类实际上就是Java里的静态单例，而静态代码是随着类加载的，只会加载一次，这样就实现了饿汉式单例
 */
object Singleton1 {
    fun doSomething() {
        println("Singleton1.doSomething")
    }
}

/**
 * 懒汉式
 * by lazy { ... }的初始化默认是线程安全的，并且能保证by lazy { ... }代码块中的代码最多被调用一次
 */
class Singleton2 private constructor() {
    companion object {
        val instances: Singleton2 by lazy { Singleton2() }
    }

    fun doSomething() {
        println("Singleton2.doSomething")
    }
}

fun main(args: Array<String>) {
    Singleton1.doSomething()
    Singleton2.instances.doSomething()
}