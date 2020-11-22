package infrn
/* 기본 타입 */
// 코틀린에서 모든 것은 객체임

// 숫자 (Number)
// char 타입 int로 처리되었지만 코틀린에서는 문자형으로 처리됨
// Integer, int -> 모든것을 Int로 처리

/* 리터럴 (Literal) */
// 10진수 : 123 (Int, Short)
// Long : 123L
// Double : 123.5, 123.5e10
// 2진수 : 123.5f
// 8진수 : 미지원
// 16진수 : 0X0f

/* Representation */
// java에서 숫자형은 JVM primitive type으로 저장됨
// Nullable이나 제네릭의 경우에는 박싱됨
// 박싱된 경우 idendtity를 유지 하지 않음
fun representation() {
    var a: Int = 10000
    var b: Int? = 10000
    println("a === b : ${a === b}") //true (primitive) , true (Object)
    println("a == b  : ${a == b}")  //true (primitive) , true (Object)
}

/* Explicit Conversions */
// 명식정으로 변환 함수를 사용해서 변환해야 함
fun explicit() {
    val a: Int =1 // infrn.A Boxed Int
    // val b:Long = a // 오류
    val b: Long = a.toLong();
    //print(a == b) //오류
}

/* 배열 */
// 배열은 Array 클래스로 표현됨
// get, set ([]연산자 오버로딩됨)
// size 등 유용한 멤버 함수 포함
fun kotlinArray() {
    var arr: Array<String> = arrayOf("코틀린","테스트")
    println(arr.get(0))
    println(arr[0])
    println(arr.size)
}

//배열 생성
fun createArray() {
    //팩토리 함수
    val a = Array(5) { i -> i.toString() }

    //라이러리 함수
    val b= arrayOf(0,1,2,3,4)
}

// 특별한 Array
// primitive 타입의 박싱 오버헤드를 없애기 위한 배열
// IntArray, ShortArray, IntArry
// Array를 상속한 클래스들은 아니지만, Array와 같은 메소드와 프로퍼티를 가짐
// size 등 유용한 멤버 함수 포함
fun intArray() {
    val x: IntArray = intArrayOf(1,2,3)
    x[0] = 7
    println(x.get(0))
    println(x[0])
    println(x.size)
}



/* 문자열 */
// String은 characters로 구성됨
// infrn.getStr[i]와 같은 방식으로 접근 가능 (immutable이므로 변경 불가)
fun str() {
    val x: String = "Kotlin"
    println(x.get(0))
    println(x[0])
    println(x.length)

    for (c in x) println(c)
}


/* 문자열 리터럴 */
// escaped string ("Kotlin")
// raw string("""Kotlin""")
fun strBlock() {
    val s = "Hello,world\n"

    val sBlock = """
       this 
        is
        raw string
    """.trimIndent()
}