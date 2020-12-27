package dimo

fun main() {

    var biData: Int = 0b10000

    biData - biData or (1 shl 2)

    println(biData.toString(2))

    var result = biData and (1 shl 4)


}


