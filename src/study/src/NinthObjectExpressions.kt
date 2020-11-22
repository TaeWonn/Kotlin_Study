import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.spi.CalendarDataProvider
import javax.swing.JComponent

/* Object Expressions */

// object 용도
//      - 어떤 class에서 조금 변경된 객체를 생성 할떄
//      - 새로운 subclass의 명시적인 선어 없이 객체 생성

// Object Expressions
//      - 자바 익명 클래스

// Object Declarations
//      - singleton

// Companion Object
//      - singleton + Class method(static)

// 객체 표현식
/*
 window.addMouseListener(object MouseAdapter() {
    override fun mouserClicked (e: MouseEvent) {}
    override fun mouserEntered (e: MouseEvent) {}
 })
*/

/*객체 표현식 상속 */
// 슈퍼타입의 생성자가 있는경우,
// 반드시 값을 전달 해 주어야 함
// 슈퍼타입이 여러 개인 경우 : 콜론뒤에 , 콤마로 구분해서 명시하면 됨
open class A(x: Int) {
    public open val y: Int = x
}
interface B{}

val ab: A = object  : A(1), B {
    override val y = 15;
}

fun testLambda() {
    val t = Thread { println("hello kotlin") }
    t.run()
}

/* 객체 표현식 상속 없는 경우 */
// 특별히 상속받을 superTypes가 없는 경우, 간단하게 작성
fun testNonSuperTypes() {
    val data =object {
            var x = 1
            var y = 1
    }

    println("${data.x}, ${data.y}")
}

// 객체 표현식 제약 조건
// 익명 객체가 local이나 private으로 선언될 때만 type으로 사용될 수 있음
// 익명 객체가 public function이나 public property에서 리턴되는 경우.
// 익명객체의 슈퍼타입으로 동작됨,
// 이런 경우 익명 객체에 추가된 멤버에 접근이 불가능함
class C {
    private fun foo() = object { val x: String = "x"}
    fun publicFoo() = object  {val x: String = "Y"}

    fun bar() {
        val x1 = foo().x
//      val x2 = publicFoo().x //Error
    }
}

// 객체 표현식 특징
// 익명 객체의 코드는 enclosing scope의 변수를 접근할 수 있음
// 자바와는 다르게 final variables 제약 조건이 없음
fun countclicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent){
            clickCount ++
        }

        override fun mouseEntered(e: MouseEvent?) {
            enterCount ++
        }
    })
}

/* 객체 선언 용도 */
// 매우 유용한 Singleton 패턴을
// 코틀린에서는 object declarations 이용해서 만들 수 있음
object DataProviderManager {
    fun registerDataProvider(provider: DataProviderManager) {
        // ...
    }

    val allDataProvider: Collection<DataProviderManager>
        get() {
            TODO()
        }
}


/* 객체 선언 문법 */
// object 키워드 뒤에 항상 이름이 있어야함
// object declaration은 object expression이 아님
// 그래서 할당 구문의 우측에 사용 될 수 가 없음

object CountManager {
    var count = 0
}
fun testCountManager () {
    CountManager.count ++
    println(CountManager.count)
    CountManager.count ++
    println(CountManager.count)
    CountManager.count ++
    println(CountManager.count)
}


/* 동반자 객체 */
// 클래스 내부의 object declaration은 companion 키워드를 붙일 수 있음
class MyClass {
    companion object Factory {  // Factory 생략 가능
        fun create() : MyClass = MyClass()
    }

    //companion object의 멤버는 클래스 이름을 통해서 호출할 수 있음
    val instance = MyClass.create()
}
// companion object의 멤버가 다른 언어의 static 멤버처럼 보일수 있지만 아니다.
// companion objectdml apaqjsms tlfwp rorcpdml apaqjdla
// 슈퍼 클래스도 가질 수 있는 클래스의 객체이다


/* object expressions VS object declaration */
// object expressions는 즉시 초기화 되고 실행 된다.
// object declarations는 나중에 초기화 된다. (최초 접근 시)
// companion object는 클래스가 로드 될 때 초기화 됨,
// java static initalizer와 매칭 됨


object MyClass1 {
    init {
        println("create MyClass1")
    }
}

object MyClass2 {
    init {
        println("create MyClass2")
    }
}
object MyClass3 {
    init {
        println("create MyClass3")
    }
}
//debug 모드로 테스트
// 첫 println에 포인트를 잡고
// memory View를 통해서 객체가 생성되어 있는지 확인
fun testing () {
    println(1)
    println(MyClass1)
    println(MyClass1)
    println(MyClass1)
    println(2)
    println(MyClass2)
    println(MyClass2)
    println(MyClass2)
    println(3)
    println(MyClass3)
    println(MyClass3)
    println(MyClass3)
}
// 테스트 결과 MyClass 객체들은 싱글톤이기 때문에 각각 한개의 인스턴스만 생성 된다.
// -> init은 한번만 호출 된다.