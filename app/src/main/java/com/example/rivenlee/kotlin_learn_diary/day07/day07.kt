package com.example.rivenlee.kotlin_learn_diary.day07

/**
 * author: rivenlee
 * date: 2019/8/1
 * email: rivenlee0@gmail.com
 */

fun main(args: Array<String>) {
    val minInt = minOf(1, 5)
    val latitude = Latitude.ofDouble(3.0)
    val latitude2 = Latitude.ofLatitude(latitude)

}

class Latitude private constructor(val value: Double){
    //伴生对象
    companion object {

        fun ofDouble(double: Double): Latitude{
            return Latitude(double)
        }

        @JvmStatic
        fun ofLatitude(latitude: Latitude): Latitude{
            return ofLatitude(latitude)
        }


        @JvmField
        val TAG = "lalalala"

        val TAG1 = "lalalala"

    }

}