package com.example.rivenlee.kotlin_learn_diary.day19



/**
 * FileName: JavaReflections
 * Author: rivenLee
 * Date: 2020/9/22 15:53
 * kotlin使用Java反射
 */
data class Person(val name: String, val age: Int)



fun main() {
    val clazz = Person::class.java
    val person = Person("riven", 18)
    val clazz2 = person.javaClass
    val clazz3 = person::class.java

    val person2 = clazz2.getConstructor(String::class.java, Int::class.java).newInstance("rivenLee", 19)
    println(person2)

    val name = clazz2.getDeclaredField("name").apply { isAccessible = true }.get(person2)
    println(name)
    val name2 = clazz2.getDeclaredMethod("getName").invoke(person2)
    println(name2)

}