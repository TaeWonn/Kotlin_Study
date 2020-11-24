package docs

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0X0000FF)
}

// Anonymous Classes
//열거 형 상수는 기본 메서드를 재정의 할뿐만 아니라 해당 메서드를 사용하여 자체 익명 클래스를 선언 할 수도 있습니다.
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };
    //열거 형 클래스가 멤버를 정의하는 경우 세미콜론으로 멤버 정의에서 열거 형 상수 정의를 분리합니다.
    // 내부 클래스 이외의 중첩된 유형을 포함할 수 없습니다.

    abstract fun signal(): ProtocolState
}

// enum은 인터페이스를 상속받을 수 있습니다
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int): Int = apply(t, u)
}

enum class RGB { RED, GREEN, BLUE }

// enumValues<T>() 및 enumValueOf<T>() 함수를 사용하여 일반적인 방식으로
// 열거 형 클래스의 상수에 액세스 할 수 있습니다.
inline fun <reified T: Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}
