package com.example.rivenlee.kotlin_learn_diary.day10

/**
 * author: rivenlee
 * date: 2019/8/29
 * email: rivenlee0@gmail.com
 */

sealed class PlayerCmd{

}

class Play(val url: String, val position: Long = 0): PlayerCmd()
object Pause : PlayerCmd()
class Seek(val position: Long)
object Stop: PlayerCmd()


