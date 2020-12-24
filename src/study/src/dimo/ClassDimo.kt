package dimo

class ClassDimo {
    var a = Person("박보영", 1990)
    var b = Person("전정국", 1997)
    var c = Person("장원영", 2004)
}

class Person(var name:String, val birthYear:Int)