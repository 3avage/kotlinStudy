package com.example.testkotlin

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
// https://juejin.cn/post/7243627371994038309
interface ISay {
    fun sayHello()
}
class DelegateImp : ISay {
    override fun sayHello() {
        println("sayHello from DelegateImp")
    }
}
// TODO 第一种用法 接口是把接口方法委托出去
class RealImp(delegateImp: DelegateImp): ISay by delegateImp{}

class Delegate(){
    //对应属性中的get()，表示获取数据
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef，${property.name}"
    }
    //对应属性中的set()，表示设置数据，只有var的属性会有
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {

        Log.debug("$thisRef , ${property.name} , $value")
    }
}
class DelegateRW : ReadWriteProperty<DelegateProperty, String> {
    override fun getValue(thisRef: DelegateProperty, property: KProperty<*>): String {
        return "getValue：$thisRef，${property.name}"
    }

    override fun setValue(thisRef: DelegateProperty, property: KProperty<*>, value: String) {
        Log.debug("setValue：$thisRef，${property.name}，$value")
    }
}

class DelegateProperty {
    // TODO 第二种用法 属性委托即是将对应的 get()/set() 操作分发给指定委托对象的 getValue()/setValue() 方法执行；
    // TODO 当然，如果是 val 修饰的属性，只需要提供 getValue() 即可
//    var p1: String by Delegate()
    var p1: String by DelegateRW()
}
// TODO 第三种lazy() 是接受一个 lambda 表达式， 并返回一个 Lazy <T> 实例的函数，
// TODO 返回的实例可以作为实现延迟属性的委托： 第一次调用属性的 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果； 后续调用直接返回已经记录的结果
val lazyView by lazy {
    Log.debug("我只有第一次初始化的时候才执行哟~")
    "Come on"
}
class ExampleActivity  {
    // TODO 第四种 可观察属性
    // Delegates.observable 传入初始化值、value变化时候的回调函数
    private var lastClickTime by Delegates.observable(0L) { _, old, new ->
        // 在lastClickTime属性值发生变化时执行点击事件
        if (new - old > 1000) {

        }
    }
}
object ByClass {
    operator fun invoke(){
        val property = DelegateProperty()
        Log.debug(property.p1) //getValue()
        property.p1 = "小马快跑" //setValue()
        Log.debug(property.p1) //getValue()
//        lazyView = "set before get"
        Log.debug(lazyView)
        Log.debug(lazyView)
    }
}