package infrn
/* Data Class */
// 용도: 데이터는 보유하지만 아무것도 하지 않는 클래스
// equals, hashCode, copy, toString, componentN 을 컴파일러가 자동 생성
// 명시적으로 정의해주는 경우, 자동으로 생성하지 않음
// 기본생성자에 대해서만 기본 메소드 제공 (equals...)
// toString은 hash코드 값 대신 프로퍼티의 명과 값을 리턴

// Data 클래스는 abstract, open, sealed, inner가 안됨

// 1.1 이후 Date 클래스 interface 구현 가능 및 sealed class 상속가능
data class User(var name:String, var age: Int)


var name:String = "name"
var age:Int = 30


fun test() {
    var obj = User("ttt", 111)
    println(obj)

    var obj2 = obj.copy("kotlin")
    println(obj2)

    var obj3 = obj2.copy(age = 888)
    println(obj3)
}

/* Destructuring Declarations */
// data 클래스는 Destructuring Declarations 사용 가능
// 컴파일러가 ComponentN 함수를 자동으로 만들어 주기 떄문
fun test2() {
    val jane = User("Jane", 35)
    val (name, age) = jane

    println("$name , $age years of age")
}

/* standard Data Classes */
// 스탠다드 라이브러리에 제공하는 data 클래스도 있음
//      - pair
//      - Triple
fun test3() {
    val (name, age) = Pair<String, Int>("hee", 1)
    println("$name , $age")
}

/* 중첩 클래스 */
class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }
}
val demo = Outer.Nested().foo()

// Inner class
// 클래스에 inner를 표기하면 바깥쪽 클래스의 멤버에 접근 할 수 있음
class Outer2 {
    private val bar: Int = 1

    inner class Nested2 {
        fun foo() = bar
    }
}
val demo2 = Outer2().Nested2().foo()

/* 익명 내부 클래스 */
// 객체 표현식을 이용해서 익명 내부 클래스의 인스턴스를 생성할 수 있음.
// Functional java interface인 경우에는
// 접두어에 인터페이스 이름을 사용해서 람다식으로 표현할 수 있음

