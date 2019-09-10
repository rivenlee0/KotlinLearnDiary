package com.example.rivenlee.kotlin_learn_diary.day15

import java.io.File

/**
 * author: rivenlee
 * date: 2019/9/9
 * email: rivenlee0@gmail.com
 * 案例
 * 统计字符串个数程序开发
 */

fun main(args: Array<String>) {
    val map = HashMap<Char, Int>()
    File("build.gradle")
            .readText()
            .toCharArray()
            .filterNot(Char::isWhitespace)
            .forEach {
                val count = map[it]       // value(count) = map.get(key(it))
                if(count == null) map[it] = 1   //map.put(key(it), value(1))
                else map[it] = count + 1
            }
    map.forEach(::println)

    //另一种形式，分组并转换函数统计字符个数
    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace)
            .groupBy { it }.map { it.key to it.value.size }
            .forEach(::println)

}


