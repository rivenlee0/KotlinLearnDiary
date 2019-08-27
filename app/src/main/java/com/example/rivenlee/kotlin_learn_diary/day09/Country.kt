package com.example.rivenlee.kotlin_learn_diary.day09


/**
 * author: rivenlee
 * date: 2019/8/6
 * email: rivenlee0@gmail.com
 */

@PoKo
data class Country(val id: Int, val name: String)

class ComponentX{
    operator fun component1(): String{
        return "您好，我是"
    }

    operator fun component2(): Int{
        return 110
    }
}

fun main(args: Array<String>) {
    val china = Country(0, "中国")
    println(china)
    println(china.component1()) //参数1
    println(china.component2()) //参数2

    val (id, name) = china
    println(id)
    println(name)

    val componentX = ComponentX()
    val (a, b) = ComponentX()
    println("$a $b")


}