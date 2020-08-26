package com.example.rivenlee.kotlin_learn_diary.design_mode.proxy


/**
 * RealSubject原对象
 */
class RealSubject : Subject() {
    override fun doSomething() {
        println("RealSubject:doSomething")
    }

}