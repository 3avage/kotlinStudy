package com.example.testkotlin
fun swap(first:Int,second:Int){
    var temp = first
//    first = second
//    second = temp
}
data class valuePassType(
    var value:Int
){}
class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        var a:Int = 10
        println("TestTag a:$a")
        var b:Int = a
        println("TestTag b:$b")
        b=100
        println("TestTag after change a:$a b:$b")
        // 上述为传值
        var strA:String = "NO change string"
        var strB:String = strA
        strB = "string changed"
        println("TestTag strA:$strA strB:$strB")



        var aData:valuePassType = valuePassType(10)
        println("TestTag aData:${aData.value}")
        var bData = aData
        println("TestTag bData:${bData.value}")
        bData.value = 100
        println("TestTag after change aData:${aData.value} bData:${bData.value}")
        //自定义类型为引用传递
        return "Hello, ${platform.name}!"
    }
}