package com.example.testkotlin

import kotlin.math.log

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
//        ValuePassTypeFunc()
//        InheritTest()
        ByClass()
        CompanionObject.invoke()
        return "Hello, ${platform.name}!"
    }
}