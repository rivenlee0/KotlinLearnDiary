package com.example.rivenlee.kotlin_learn_diary.day08

import kotlin.reflect.KProperty

/**
 * author: rivenlee
 * date: 2019/8/5
 * email: rivenlee0@gmail.com
 */

class Delegates{
    //代理属性
    val hello by lazy {
        "Hello World"
    }

    val hello2 by X()
    var hello3 by X()

}

class X{
    private var value: String?= null
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String{
        return value?: "Hello World X"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        this.value = value
    }
}

fun main(args: Array<String>) {
    val delegates = Delegates()
    println(delegates.hello)
    println(delegates.hello2)
    println(delegates.hello3)
    delegates.hello3 = "Hello World 3"
    println(delegates.hello3)


}