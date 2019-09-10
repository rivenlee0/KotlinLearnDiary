package com.example.rivenlee.kotlin_learn_diary.day12

import java.io.BufferedReader
import java.io.FileReader

/**
 * author: rivenlee
 * date: 2019/9/4
 * email: rivenlee0@gmail.com
 */
data class Person(val name: String, val age: Int){
    fun work(){
        println("$name is working!!!")
    }
}

fun main(args: Array<String>) {

    findPerson()?.let {
        println(it.age)
        it.work()
    }
    
    findPerson()?.let { person ->
        println(person.age)
        person.work()
    }

    findPerson()?.apply {
        println(age)
        work()
    }

    BufferedReader(FileReader("text.txt")).use {
        var line: String?
        while (true) {
            line = it.readLine()?:break
            println(line)
        }

    }
}

fun findPerson(): Person? {
    return null
}