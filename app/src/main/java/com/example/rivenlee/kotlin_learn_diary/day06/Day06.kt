package com.example.rivenlee.kotlin_learn_diary.day06

/**
 * author: rivenlee
 * date: 2019/7/31
 * email: rivenlee0@gmail.com
 */

abstract class Person(open val age: Int){
    //    open fun work(){
//
//    }
    abstract fun work()
}

class MaNong(age: Int):Person(age){
    override val age: Int
        get() = 0
    override fun work() {
//        super.work()
        println("我是码农，我在写代码")
    }
}

class Doctor(age: Int):Person(age){
    override fun work() {
//        super.work()
        println("我是医圣，我在给病人看病")
    }
}

fun main(args: Array<String>){
    val person: Person = MaNong(23)
    person.work()
    println(person.age)

    val person2: Person = Doctor(24)
    person2.work()
    println(person2.age)
}