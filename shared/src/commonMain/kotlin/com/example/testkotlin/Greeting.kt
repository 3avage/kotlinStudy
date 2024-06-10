package com.example.testkotlin

import kotlin.math.log

fun swap(first: Int, second: Int) {
    var temp = first
//    first = second
//    second = temp
}

data class valuePassType(
    var value: Int
) {}

fun valuePassTypeFunc() {
    var a: Int = 10
    println("TestTag a:$a")
    var b: Int = a
    println("TestTag b:$b")
    b = 100
    println("TestTag after change a:$a b:$b")
    // 上述为传值
    var strA: String = "NO change string"
    var strB: String = strA
    strB = "string changed"
    println("TestTag strA:$strA strB:$strB")


    var aData: valuePassType = valuePassType(10)
    println("TestTag aData:${aData.value}")
    var bData = aData
    println("TestTag bData:${bData.value}")
    bData.value = 100
    println("TestTag after change aData:${aData.value} bData:${bData.value}")
    //自定义类型为引用传递
}

interface base {
    var data: Int
    fun add() {
        println("TestTag i am base")
    }

}

interface subA : base {

}

interface subB : base {
    override fun add() {
        super.add()
        println("TestTag i am subB")
    }
}

interface subC : subA, subB {
    override fun add() {
        println("TestTag i am subC")
    }

    fun test() {
        data = 100
        add()
        super<subB>.add()
    }
}

fun inheritTest() {
    //    open class base(var data:Int)
//
//    open class subA(data: Int) : base(data){}
//
//    open class subB(data:Int) : base (data){}
//
//    open class subC(data:Int) : subA(data),subB(data){}
    var a = object : subC {
        override var data: Int = 10
        override fun add() {
            super.add()
        }
    }
    a.add()
    a.test()
}

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        valuePassTypeFunc()
        inheritTest()
        return "Hello, ${platform.name}!"
    }
}