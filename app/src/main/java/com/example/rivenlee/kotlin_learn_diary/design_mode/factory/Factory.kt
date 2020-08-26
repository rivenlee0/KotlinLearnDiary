package com.example.rivenlee.kotlin_learn_diary.design_mode.factory

/**
 * FileName: Factory
 * Author: rivenLee
 * Date: 2020/8/26 9:08
 * 简单工厂模式
 */

interface Factory {
    fun create(): Product
}

class FactoryA :Factory {
    override fun create() = ProductA()
}

class FactoryB :Factory {
    override fun create() = ProductB()
}

class FactoryC :Factory {
    override fun create() = ProductC()
}

fun main(args: Array<String>) {
    val factoryA = FactoryA()
    val factoryB = FactoryB()
    val factoryC = FactoryC()

    println(factoryA.create())
    println(factoryB.create())
    println(factoryC.create())

}