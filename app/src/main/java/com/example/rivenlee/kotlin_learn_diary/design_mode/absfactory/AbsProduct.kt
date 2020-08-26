package com.example.rivenlee.kotlin_learn_diary.design_mode.absfactory

/**
 * A产品线路
 */
abstract class AbsProductA {

    fun doShare() {
        println("doShareA")
    }

    abstract fun doSomething()
}

/**
 * B产品线
 */
abstract class AbsProductB {

    fun doShare() {
        println("doShareB")
    }

    abstract fun doSomething()
}

class ProductA1 : AbsProductA() {
    override fun doSomething() {
        println("doSomething.productA1")
    }
}

class ProductA2 : AbsProductA() {
    override fun doSomething() {
        println("doSomething.productA2")
    }
}

class ProductB1 : AbsProductB() {
    override fun doSomething() {
        println("doSomething.productB1")
    }
}

class ProductB2 : AbsProductB() {
    override fun doSomething() {
        println("doSomething.productB2")
    }
}