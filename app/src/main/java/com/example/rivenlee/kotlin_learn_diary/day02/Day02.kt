package com.example.rivenlee.kotlin_learn_diary.day02

/**
 * author: rivenlee
 * date: 2018/11/7
 * email: rivenlee0@gmail.com
 */

class 妹纸(var 性格:String , var 长相:String, var 声音:String){
    fun 唱歌(歌名:String){
        println("妹纸正在唱歌:$歌名")
    }


}

fun main(){
    val 妹纸 = 妹纸("彪悍", "凤姐", "粗犷")
    妹纸.唱歌("学猫叫")
}