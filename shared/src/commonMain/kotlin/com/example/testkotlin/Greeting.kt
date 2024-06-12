package com.example.testkotlin

import kotlin.math.log

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
//        ValuePassTypeFunc()
//        InheritTest()
        ByClass()
        return "Hello, ${platform.name}!"
    }
}