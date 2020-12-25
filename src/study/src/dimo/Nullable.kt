package dimo

fun main() {

    var a :String? = "Kotlin Exam"

    a?.run {
        println(toUpperCase())
        println(toLowerCase())
    }
    
    var b = Product("콜라", 1000)
    var c = Product("콜라", 1000)
    var d = b
    var e = Product("사이다", 1000)

    println(b == c)
    println(b === c)

    println(b == d)
    println(b === d)

    println(b == e)
    println(b === e)
}

class Product (val name: String, val price:Int) {
    override fun equals(other: Any?): Boolean {
        return if(other is Product){
            other.name == name && other.price == price
        } else {
            false
        }
    }
}