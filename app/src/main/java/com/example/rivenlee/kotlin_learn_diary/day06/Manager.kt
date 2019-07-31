package com.example.rivenlee.kotlin_learn_diary.day06

/**
 * author: rivenlee
 * date: 2019/7/31
 * email: rivenlee0@gmail.com
 */
class Manager: Driver, Writer{
    override fun drive() {
    }

    override fun writer() {
    }
}
// Driver by driver, Writer by writer
// kotlin接口代理;
class SeniorManager(val driver: Driver, val writer: Writer): Driver by driver, Writer by writer

class CarDriver: Driver {
    override fun drive() {
        println("司机在开车")
    }
}

class PPTWriter: Writer {
    override fun writer() {
        println("PPT写手做PPT")
    }
}

fun main(args: Array<String>) {
    val driver = CarDriver()
    val writer = PPTWriter()
    val seniorManager = SeniorManager(driver, writer)
    seniorManager.drive()
    seniorManager.writer()

}
interface Driver{
    fun drive()
}

interface Writer{
    fun writer()
}