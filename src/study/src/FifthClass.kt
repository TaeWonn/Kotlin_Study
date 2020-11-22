package infrn

// Header 와 Body는 옵션이고, Body가 없으면 {}도 생략 가능
class Empty

/* 기본 생성자 */
// 클래스 별로 1개만 가질수 있음
// 클래스 해더의 일부
class Person constructor(name:String)

// 어노테이션이나 접근지정자가 없을 때는,
// 기본생성자의 constructor 키워드를 생략가능
class Person2(name: String)

// 기본생성자는 코드를 가질 수 없음
//      - 초기화는 초기화 블록안에서 작성해야 함
//      - 초기화 블록은 init 키워드로 작성
// 기본생성자의 파라매터는 init 블록안에서 사용 가능함
class Customer(name: String){
    val customerKey = name.toUpperCase();
    init {
        println("infrn.Customer initialized with value $name")
    }
}

// infrn.Custom.fullname = "kotlin"
// Getter와 Setter를 가진것 처럼 사용가능 하다
class Custom() {
    var fullname:String = ""
}

// 기본생성자에 어노테이션 접근지정자 등이 있는 경우 constructor 키워드로 선언
//class Customers public @Inject constructor(name: String) { ... }


/* 보조 생성자 */
// 여러개 선언 가능
class Persons {
    constructor(parent: Persons) {
        //parent.children.add(this)
    }
}

// 생성자끼리 호출 가능 (this 키워드를 이용)
// 클래스가 기본생성자를 가지고 있다면, 각각의 보조생성자들은
// 기본생성자를 직접 or 간접적으로 위임해 주어야 한다.
class Persons2 (val name: String) {
    constructor(name: String, parent: Persons2): this(name){}

    constructor(): this("홍길동", Persons2()) {}

}

/* 생성된(generated) 기본생성자 */
// 클래스에 기본생성자 or 보조생성자를 선언하지 않으면, 생성된 기본생성자가 만들어짐
// generated primary constructor
//      - 매개변수가 없음
//      - 가시성이 public

// 만약 생성된 기본생성자의 가시성이 public이 아니여야 한다면,
// 다른 가시성을 가진 빈 기본생성자를 선언해야 함
class DontCreateMe private constructor(){}


/* 인스턴스 생성 */
// 코틀린은 new 키워드가 없음
// 객체를 생성하려면 생성자를 일반 함수처럼 호출 하면 됨
fun instance(){
    val custom = Custom()

    val customer = Customer("Joe Smith")
}

/* 클래스 멤버 */
// 클래스는 아래의 것들은 포함할 수있음
// - Constructors and initializer blocks
// - Functions
// - Properties
// - Nested and Inner Classes
// - Object Declarations