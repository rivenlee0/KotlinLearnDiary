package com.example.rivenlee.kotlin_learn_diary.design_mode.factory

/**
 * FileName: Product
 * Author: rivenLee
 * Date: 2020/8/26 9:09
 */

interface Product {
    val name: String
}

class ProductA(override val name: String = "productA") : Product {
    override fun toString(): String {
        return name
    }
}

class ProductB(override val name: String = "productB") : Product {
    override fun toString(): String {
        return name
    }
}

class ProductC(override val name: String = "productC") : Product {
    override fun toString(): String {
        return name
    }
}