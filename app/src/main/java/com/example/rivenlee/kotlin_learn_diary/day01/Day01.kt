package com.example.rivenlee.kotlin_learn_diary.day01

/**
 * author: rivenlee
 * date: 2018/11/6
 * email: rivenlee0@gmail.com
 */

//常量字符串
val FINAL_HELLO_WORLD: String = "HelloWorld"
//变量字符串 - 类型推导
var helloWorld = "HelloWorld"
//编译期常量 同等为Java - public final String HELLO_WORLD
const val HELLO_WORLD= "HelloWorld"

//无返回值函数默认返回为Unit
fun method01(args: Array<String>):Unit{
    //字符串模板写法
    println("hello, ${args[0]}")
}

fun sum(arg1:Int, arg2:Int): Int{
    return arg1 + arg2
}
//上方函数可写成如下形式
fun sum2(arg1:Int, arg2: Int) = arg1 + arg2

//变量值可写成匿名函数形式 ，
var int2Long = fun(x:Int): Long{
    return x.toLong()
}

/**
 * Lambda表达式
 */

var variable = { arg1:Int, arg2:Int -> arg1 + arg2 }

fun sum3(args: Array<String>){
    println(variable(1,3))
//    想大于invoke方法
//    println(variable.invoke(1,3))

    for(i in args){
        println(i)
    }

    args.forEach {
        println(it)
    }
//    super简化
//    args.forEach(::println)

//    return当前foreach表达式，代码继续向下执行
    args.forEach ForEach@ {
        if(it == "a") return@ForEach
        println(it)
    }

}





