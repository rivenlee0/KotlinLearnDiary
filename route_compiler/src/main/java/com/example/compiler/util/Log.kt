package com.example.compiler.util

import javax.annotation.processing.Messager
import javax.tools.Diagnostic


/**
 * FileName: Log
 * Author: rivenLee
 * Date: 2020/9/7 17:22
 */
class Log private constructor(private val messager: Messager) {
    fun i(msg: String?) {
        messager.printMessage(Diagnostic.Kind.NOTE, msg)
    }

    companion object {
        fun newLog(messager: Messager): Log {
            return Log(messager)
        }
    }

}