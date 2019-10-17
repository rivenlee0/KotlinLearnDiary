package com.example.rivenlee.kotlin_learn_diary.day17

import android.util.Log
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Logger

/**
 * author: rivenlee
 * date: 2019/9/16
 * email: rivenlee0@gmail.com
 */

private suspend fun coroutineStart(){
    /**
     * DEFAULT - 立即开始调度协程体
     * LAZY - 只有在需要(start/join/await)时开始调度
     * ATOMIC - 立即开始调度，且在第一个挂起点前不能被取消
     * UNDISPATCHED - 立即在当前线程执行协程体，直到遇到第一个挂起点（后面取决于调度器）
     */
    GlobalScope.launch(start = CoroutineStart.DEFAULT) {

    }
    val launch = GlobalScope.launch(start = CoroutineStart.LAZY) {

    }
    launch.start()

    GlobalScope.launch(start = CoroutineStart.ATOMIC) {

    }
    GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {

    }

    GlobalScope.launch {

    }


}


