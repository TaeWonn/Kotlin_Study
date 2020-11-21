/* if else 문 */
// 삼항연산자(ternary)가 없음
fun ifTest() {
    val a: Int = 0
    val b: Int = 1

    var max = if (a > b) a else b

    //블록의 마지막 구문이 반환 값이 됨
    val max2 = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }
}

/* when */
// else문이 필수다
fun whenTest() {
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }

    var res = when(x) {
        100 -> "A"
        90  -> "B"
        80  -> "C"
        else -> "F"
    }

    when(x) {
        0,1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    when(x) {
        x.toInt() -> print("s encodes x")
        1 +3 -> print("4")
        else -> print("s does not encode x")
    }

    val validNumbers = listOf(3,6,9)
    when (x) {
        in validNumbers -> print("x is valid")
        in 1..10 -> print("x is the range")
        !in 10..20 -> print("x is outside tih range")
        else -> print("none of th above")
    }

    // when에 인자를 입력하지 않으면, 논리연산 처리됨
//    when {
//        x.isOdd() -> println("x is odd")
//        x.isEven() -> println("x is even")
//        else -> println("x is funny")
//    }
}

// when 스마트캐스트
fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}

/* For Loops */
fun forTest() {
    val collection: Array<String> = arrayOf("1","2")

    // for 문은 iterator을 제공하는 모든 것을 반복할 수 있음
    for(item in collection)
        print(item)

    // for 문의 Body가 블록이 올 수도 있음
    for(item in collection) {
        //print(item.id)
        //print(item.name)
    }


}

class MyIterator {
    val data = listOf(1,2,3,4,5)
    var idx = 0
    operator fun hasNext(): Boolean {
        return data.size > idx
    }

    operator fun next(): Int {
        return data[idx++]
    }
}

class MyData {
    operator fun iterator(): MyIterator {
        return MyIterator()
    }
}

// For문을 지원하는 iterator의 조건
// 멤버함수나 확장함수 중
// iterator()를 반환 하는 것이 있는 경우
// next()를 가지는 경우
// hasNext(): Boolean를 가지는 경우
// 위 3 함수는 operator로 표기 되어야 함
fun iteratorTest() {
    val myData = MyData()
    for (item in myData)
        print(item)
}

fun forIndex() {
    val array = arrayOf("가","나","다")

    // index를 이용하고 싶다면 indices를 이용
    for(i in array.indices)
        print("$i : ${array[i]}")

    // index를 이용히고싶을떄, withIndex를 이ㅛㅇ
    for ((index, value) in array.withIndex()) {
        print("$index : $value")
    }
}


/* while Loop */
fun whileTest() {

    while(x > 0) {
        x --
    }

    //do while은 Body 안에 변수를 사용할 수 있다.
    do {
        val y = null
    }while (y != null)
}