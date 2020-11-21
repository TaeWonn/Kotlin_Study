import javax.security.auth.Subject

/* Properties and Fields */
// 코틀린 클래스는 프로퍼티를 가질수 있음
//      - var (mutable) / val (read-only)

// 프로퍼티 문법
// var <propertyName>[: <PropertyType> [=<property_initializer>]]
// [<getter>]
// [<setter>]
class Address {
    val city:String = "Seoul"
    var name:String = "Kotlin"
        get() {return  field}       // 생략 가능
        set(value) { field = value} // 생략 가능


    private var size:Int = 0

    // 프로퍼티 사용은 자바의 필드를 사용하듯이 하면 됨
    fun copyAddress(address: Address): Address {
        val result = Address()
        result.name = address.name
        // ...
        return result
    }

    /* var */
    // default getter와 setter
    // 타입은 Int
    var initialized = 1

    // error: 오류 발생
    // default getter와 setter를 사용한 경우
    // 명시적인 초기화가 필요함
    //var allByDefault: Int?

    /* val */
    // default getter
    // setter가 없음

    /* Custom accessors */
    // getter
    val isEmpty: Boolean
        get() = this.size == 0

    // setter
    var stringRepresentation:String = ""
        get() = this.toString()
        set(value) { field = value.toString() }


    /* 타입 생략 */
    // 코틀린 1.1 부터는 getter를 통해 타입을 추론 할 수있는경우
    // 프로퍼티의 타입을 생략할 수 있음
    val isEmpty2
        get() = this.size == 0  // has type Boolean



    /* 프로퍼티 */
    // accessor에 가시성 변경이 필요하거나
    // accessor에 어노테이션이 필요한 경우
    // 기본 accessor의 수정없이 body없는 accessor를 통해 정의가능
    var setterVisibility:String = "abc"
        private set // Body 생략 가능

    var setterWiuthAnnotation: Any? = null
        //@Inject set // annotate the setter with Inject

    /* Backing Fields */
    // 코틀린 클래스는 field를 가질수 없음
    // `field`라는 식별자를 통해 접근할 수 있는,
    // automatic backing field를 제공함
    // field는 프로퍼티의 accessor에서만 사용 가능 함
    var counter = 0
        set(value) {
            if(value >= 0) field = value
        }

    // 생성조건
    // accessor 중 1개라도 기본 구현을 사용하는 경우
    // custom accessor에서 field 식별자를 참조하는 경우
    val isEmpty3: Boolean
        get() { return false }
    
}

/* compile-Time constants */
// Top-level 이거나
// object의 멤버이거나
// String 이나 primitive 타입으로 초기화된 경우만 사용 가능
const val SUBSYSTEM_DEPRECATED:String = "This is subsystem is deprecated"

@Deprecated(SUBSYSTEM_DEPRECATED)
fun foo() {}


/* Late-Initialized Properties */
// 일반적으로 프로퍼티는 non-null 타입으로 서언됨
// 간혹 non-null 타입 프로퍼티를 사용하고 싶지만,
// 생성자에서 초기화를 해줄 수 없는 경우가 있음
//      Dependency Injection
//      Butter Knife
//      Unit test의 setup 메소드
public class MyTest {
    lateinit var subject: Subject

    /*@Setup*/ fun setup() {
        subject = Subject()
    }

    /*@Test*/ fun test() {
        subject.toString()
    }
}