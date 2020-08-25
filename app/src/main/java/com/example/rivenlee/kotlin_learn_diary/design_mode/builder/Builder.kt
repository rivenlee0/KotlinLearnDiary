package com.example.rivenlee.kotlin_learn_diary.design_mode.builder

/**
 * FileName: Builder
 * Author: rivenLee
 * Date: 2020/8/25 16:15
 */

class Dialog {
    var left: String = ""
    var right: String = ""
    var title: String = "title"
}

/**
 * 关键方法在于apply函数，它使得代码块能够在当前对象语境下，访问其非私有属性和函数，执行完毕后返回当前对象:
 */
fun main(args: Array<String>) {
    val dialog = Dialog().apply {
        left = "left"
        right = "right"
        title += ", title"
    }
    print(dialog.left.plus(" = ${dialog.right}").plus(" = ${dialog.title}"))
}