package com.example.testkotlin
class A{}
class Reflect {
    var aData = A::class
//    var aJavaData = A::class.java
}
class CompanionObject{
    // 实际上就是将一个单例类写到某个类的内部
    companion object {
        operator fun invoke(){
            Log.debug("companion object func invoke")
        }
        var instanceStr:String = "companion object instanceStr"
    }
    object tool{
        operator fun invoke(){
            Log.debug("companion object tool  tool func invoke")
        }
        var instanceStr:String = "companion object tool tool instanceStr"
    }
}
object tool{
    operator fun invoke(){
        Log.debug("companion object tool  tool func invoke")
    }
    var instanceStr:String = "companion object tool tool instanceStr"
}