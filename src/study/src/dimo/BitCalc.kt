package dimo

fun main() {

    var biData: Int = 0b10000

    biData - biData or (1 shl 2)

    println(biData.toString(2))

    var result = biData and (1 shl 4)
    println(result.toString())

    println(result shr 4)

    biData = biData and((1 shl 4).inv())
    println((biData xor(0b10100)).toString(2))

}


