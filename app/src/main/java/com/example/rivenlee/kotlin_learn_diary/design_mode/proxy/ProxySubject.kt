package com.example.rivenlee.kotlin_learn_diary.design_mode.proxy

/**
 * 代理类
 */
class ProxySubject(private val subject: Subject?) :Subject(){
    override fun doSomething() {
        println("before doSomething")
        subject?.doSomething()
        println("after doSomething")
    }
}