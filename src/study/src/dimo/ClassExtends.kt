package dimo


fun main() {
    var a = Animal("별이",5 ,"개")
    var b = Dog("별이",5)

    a.introduce()
    b.introduce()

    b.bark()
}

open class Animal(var name:String, var age:Int, var type:String){
    fun introduce() {
        println("이름: $name, 나이 : $age, type: $type")
    }
}

class Dog (name:String, age: Int):Animal(name, age, "개") {
    fun bark() {
        print("멍멍")
    }
}