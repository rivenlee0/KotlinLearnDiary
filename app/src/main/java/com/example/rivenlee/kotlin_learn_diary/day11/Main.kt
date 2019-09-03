package com.example.rivenlee.kotlin_learn_diary.day11

/**
 * author: rivenlee
 * date: 2019/8/30
 * email: rivenlee0@gmail.com
 */

fun main(args: Array<String>) {
    args.forEach(::println)
    val helloWord = Hello::world
    args.filter(String::isNotEmpty)

    val pdfPrinter = PDFPrinter()
    args.forEach(pdfPrinter::print)
}

class PDFPrinter{
    fun print(obj: Any){
        kotlin.io.print(obj)
    }
}
class Hello{
    fun world(){
        println("Hello World.")
    }
}