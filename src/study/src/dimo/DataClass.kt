package dimo

fun main() {

    val a = General("보일",212)

    println(a == General("보잉",212))
    println(a.hashCode())
    println(a)

    val b= Data("루다",306)
    println(b == Data("루다",306))
    println(b.hashCode())
    println(b)
    
    println(b.copy())
    println(b.copy("아린"))
    println(b.copy(id = 618))

    // ---

    val list = listOf(Data("보잉",212), Data("루다",306), Data("아린",618))

    for((aa, bb) in list) {
        println("$aa , $bb")
    }
}

class General(val name: String, val id: Int)

data class Data(val name: String, val id: Int)

