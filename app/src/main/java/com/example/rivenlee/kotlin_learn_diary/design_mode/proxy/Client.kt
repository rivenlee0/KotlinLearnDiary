package com.example.rivenlee.kotlin_learn_diary.design_mode.proxy

/**
 * FileName: Client
 * Author: rivenLee
 * Date: 2020/8/26 15:40
 */

fun main(args: Array<String>) {
    val subject = RealSubject()
    val proxySubject = ProxySubject(subject)
    proxySubject.doSomething()
}