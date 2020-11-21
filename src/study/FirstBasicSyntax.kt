
fun main(args: Array<String>) {
    println("Hello World")
}

/* 함수 정의 */

fun sum1(a:Int, b:Int):Int{
    return a+b
}

// 리턴 타입이 추론되어 반환
fun sum2(a:Int, b:Int) = a+b

// 리턴 할 값이 없는 경우 Unit(Object)으로 리턴한다.
// Unit는 java에서 void 리턴 역할
fun printKotlin(): Unit{
    println("hello kotlin")
}

// Unit은 생략 가능
fun printKotlin2() { println("hello kotlin") }




/* 지역 변수 정의 */
// val: 읽기전용 변수
// 값의 할당이 1회만 가능, java의 final과 유사
val a:Int =1    //즉시 할당
val b= 2        // `Int` type 추론
//val c:Int     // 컴파일 오류, 초기화 필요
//c = 3         // 컴파일 오류, 읽기전용

// var : Mutable 변수
var x= 5



/* 문자열 템플릿 */
var str = 1
var s1 = "a is $a"

val s2 = "${s1.replace("is","was")}, but now is $a"


/* 조건문 */
fun maxOf(a: Int, b: Int) = if(a > b) a else b


/* nullable */
/*
fun parseInt(str: String) :Int? {
    // 정수가 아닌 경우 null을 리턴
    // ?을 리턴받은 메소드는 반드시 널처리를 해야한다.
}
*/


/* 자동 타입 변환 */
fun getStringLength(obj: Any): Int?{
    // 형변환을 자동으로 해줌
    if(obj is String) return obj.length
    return null;
}


/* when expression */
fun describe(obj: Any): String =
    when (obj) {
        1           -> "One"
        "HEllo"     -> "Greeting"
        is Long     -> "Long"
        !is String  -> "Not a String"
        else        -> "Unknown"
    }


/* ranges */
fun ranges() {
    val xx= 3
    if (xx in 1..10) println("fits in range")

}
fun rangesForLoop() {
    for (x in 1..5) print(x)
}


/* Collections */
// 컬렉션도 in으로 loop 가능
fun collectionLoop() {
    val items = listOf("apple","banana","kiwi")
    for (item in items) println(item)
}

// in으로 해당 값이 collection에 포함되는지 체크 가능
fun collectionLoopWithWhen() {
    val items = setOf("apple","banana","kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple"  in items -> println("apple is fine too")
    }
}

//람다식을 이용해서 컬렉션에 filter, map 등의 연산가능
fun collectionLamda() {
    val fruits = listOf("apple","banana","kiwi")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}
