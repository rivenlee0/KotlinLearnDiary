package com.example.rivenlee.kotlin_learn_diary.design_mode.absfactory

/**
 * 抽象工厂模式
 */

abstract class AbsFactory {
    abstract fun createA(): AbsProductA
    abstract fun createB(): AbsProductB
}

class Factory1: AbsFactory() {
    override fun createA() = ProductA1()
    override fun createB() = ProductB1()
}

class Factory2: AbsFactory() {
    override fun createA() = ProductA2()
    override fun createB() = ProductB2()
}

fun main(args: Array<String>) {
    val fac1 = Factory1()
    fac1.createA().doSomething()
    fac1.createB().doSomething()

    val fac2 = Factory2()
    fac2.createA().doSomething()
    fac2.createB().doSomething()
}