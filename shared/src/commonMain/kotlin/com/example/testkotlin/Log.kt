package com.example.testkotlin

class Log {
    companion object {
        val tag: String = "TestTag"
        fun info(message:String) {
            println("$tag : $message")
        }

        fun debug(message:String) {
            println("$tag : $message")
        }
        fun error(message:String,throwable: Throwable) {
            println("$tag : $message ")
            println("$tag : error stack: $throwable ")
        }
    }
}