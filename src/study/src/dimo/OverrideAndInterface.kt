package dimo

fun main() {

    var t = Tiger()
    var a = Animals()

    a.eat()
    t.eat()
}

open class Animals {
    open fun eat() {
        println("먹다")
    }
}

class Tiger : Animals() {
    override fun eat() {
        println("고기 먹다")
    }
}

abstract class Animals2 {
    abstract fun eat() 
    fun sniff() {
        print("킁킁")
    }
}
class Rabbit: Animals2() {
    override fun eat() {
        print("먹다")
    }
}

interface Runner {
    fun run()
}

interface Eater {
    fun eat() {
        println("먹다")
    }
}
class Dogs: Runner, Eater {
    override fun run() {
        println("우다다다")
    }

    override fun eat() {
        println("많이 먹다")
    }
}