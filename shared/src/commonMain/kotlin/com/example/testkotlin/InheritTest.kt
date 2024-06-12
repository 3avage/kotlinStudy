package com.example.testkotlin
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
object InheritTest {
    operator fun invoke(){
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
}