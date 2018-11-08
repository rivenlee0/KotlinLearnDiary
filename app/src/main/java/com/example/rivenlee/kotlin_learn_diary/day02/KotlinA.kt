package com.example.rivenlee.kotlin_learn_diary.day02

/**
 * author: rivenlee
 * date: 2018/11/8
 * email: rivenlee0@gmail.com
 */
class Z

class X{

    var a = 0
        set(value) {
            field = value
        }
    get() = field
    //延迟初始化
    lateinit var b: String
    //延迟初始化
    lateinit var c:X
    //使用 by lazy初始化， 返回一个Lambda表达式
    val d:Z by lazy {
        Z()
    }



}