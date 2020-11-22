package infrn/* 패키지 */
// 소스 파일은 패키지 선언으로 시작 됨
// 모든 컨텐츠(클래스, 함수...)은 패키지에 포함 됨
// 패키지를 명세하지 않으면 이름이 없는 기본 패키지에 포함됨

// Collections도 기본 패키지 이다.

// import [package] as [별칭]

/* labelDefinition */
fun lable () {

    loop@ for(i in 1..10) {
        println("--- i : $i")

        for(j in 1..10) {
            println("j: $j")
            break@loop
        }
    }
}

fun foo1() {
    var ints = listOf(0,1,2,3)

    // return 시 forEach 만 종료되고 infrn.foo1 함수는 리턴되지 않는다.
    ints.forEach(fun(value: Int){
        if (value == 1) return
        println(value)
    })
    println("END")

}

fun foo2() {
    var ints = listOf(0,1,2,3)

    // 람다는 함수가 아니기에 0만 출력되고 리턴한다.
    ints.forEach {
        if(it == 1) return
        println(it)
    }
    println("END")

}

fun foo3() {
    var ints = listOf(0,1,2,3)

    // label 을 이용해서 람다만 infrn.foo1 함수와 같은 결과값을 얻을수 있다.
    ints.forEach label@{
        if(it == 1) return@label
        println(it)
    }
    println("END")

}

fun foo4() {
    var ints = listOf(0,1,2,3)

    // 암시적 레이블을 통한 람다식 리턴
    ints.forEach {
        if(it == 1) return@forEach
        println(it)
    }
    println("END")

}
