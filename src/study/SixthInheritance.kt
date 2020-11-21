/* 상속 */
// 코틀린의 최상위 클래스는 Any임
// 클래스 상위타입을 선언하지 않으면 Any가 상속됨
class Example1          //암시적인 상속
class Example2 : Any()  //명시적인 상속


// open을 통해 상속 가능하게 지정
open class Base(p: Int)

// 콜론을 뒤에 상위 타입을 선언
// 파생클래스에 기본생서자가 있으면,
// 파생클래스의 기본생성자에서 상위 타입의생성자를 호출해서 초기활 수 있음
class Derived(p: Int): Base(p)


// 파생 클래스에 기본 생성자가 없으면,
// 각각의 보조생성자에서 상위타입을 super 키워드를 이용해서 초기화
// or 다른 생성자에게 사위타입을 초기화할 수 있게 위임해주어야 함
class MyBase: Base {
    constructor() :super(1)

    constructor(ctx: Int): this()

    //constructor(ctx: Int, attrs:Int) super(ctx, attrs)
}


// open 어노테이션은 java의 final과 반대임
// open class는 다른 클래스가 상속할 수 있음
// 기본적으로 코틀린의 모든 class는 final임
// 이유 : Effective Java, Item 17: Design and document for inheritance or else prohibit it


/* 메소드 오버라이딩 */
// 함수에 open을 붙여야 오버라이드가 가능하다
open class Base2 {
    open fun v() {}
    fun nv() {}
}

// override를 붙여 함수를 override를 한다.
class  Derived2(): Base2() {
    override fun v(){}
}

/* 프로퍼티 오버라이딩 */
open class Foo {
    //open val x:Int get{ ... }
}
class Bar1: Foo() {
    //override  val x: Int = ...
}

/* 오버라이딩 규칙 */
// 같은 멤버에 대한 중복된 구현을 상속받은 경우,
// 상속받은 클래스는 해당 멤버를 오버라이딩하고
// 자체구현을 제공해야 함
open class A{
    open fun f(){ print("A")}
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") }
    fun b() { print("b") }
}

class C(): A(), B {
    override fun f() {
        super<A>.f() // call to A.f()
        super<B>.f() // call to B.f()
    }
}

/* 추상 클래스 */
// abstract 멤버는 구현이 없음
// abstract 클래스나 멤버는 open이 필요 없음
abstract class AbsClass {
    abstract fun f()
}
class MyClass(): AbsClass() {
    override fun f() { /* 구현 */}
}