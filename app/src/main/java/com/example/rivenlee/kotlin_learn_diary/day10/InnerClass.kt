package com.example.rivenlee.kotlin_learn_diary.day10

/**
 * author: rivenlee
 * date: 2019/8/29
 * email: rivenlee0@gmail.com
 */

class Outter{
    val a: Int = 0

    private inner class Inner{
        val a = this@Outter.a
        val b = this@Inner.a
    }

    fun main(args: Array<String>){
        val a = Outter().Inner()
    }
}

