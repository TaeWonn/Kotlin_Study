package dimo

fun main() {

    val foodCourt = FoodCourt()

    foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PASTA)
    foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
    foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)

    println("-----")

    val a = LateInitSample()

    println(a.getLateInitText())
    a.text = "새로운 값"
    println(a.getLateInitText())

    println("-----")

    val number: Int by lazy {
        println("초기화")
        7
    }

    println("코드를 시작합니다")
    println(number)
    println(number)

}

class FoodCourt {
    fun searchPrice(foodName: String) {
        val price = when(foodName) {
            FOOD_CREAM_PASTA -> 13000
            FOOD_STEAK -> 25000
            FOOD_PIZZA -> 15000
            else -> 0
        }

        println("${foodName}의 가격은 ${price}원 입니다.")
    }

    companion object {
        const val FOOD_CREAM_PASTA = "크림파스타"
        const val FOOD_STEAK = "스테이크"
        const val FOOD_PIZZA = "피자"
    }
}

class LateInitSample {
    lateinit var text: String

    fun getLateInitText(): String {
        return if (::text.isInitialized) {
            text
        } else {
            "기본값"
        }
            
    }
}

