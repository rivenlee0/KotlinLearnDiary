package com.example.rivenlee.kotlin_learn_diary.day08

/**
 * author: rivenlee
 * date: 2019/8/5
 * email: rivenlee0@gmail.com
 */

class OverLoads{
    fun a(): Int{
        return 0
    }

    fun a(int: Int): Int{
        return int
    }
    fun a(str: String): Int{
        return str.length
    }
    //函数默认值，如供Java调用，需加@JvmOverloads注解。 Java调用可不加参数。
    @JvmOverloads
    fun b(int: Int = 0): Int{
        return int
    }
}

fun main(args: Array<String>) {

}