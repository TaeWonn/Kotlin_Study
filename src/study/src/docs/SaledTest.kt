package docs

/*
    sealed class는 하위 클래스를 가질 수 있지만,
    클래스 내부 또는 동일한 파일에서 선언되어야 합니다.
 */
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr): Expr()
object NotANumber: Expr()

/*
    sealed 는 abstract 이며 직접 인스터스화 할 수 없습니다.
    abstract member 를 가질 수 있습니다.
    sealed 의 하위 클래스를 상속 받는 클래스는 위치(경로)에 제약을 받지 않습니다.

    sealed class 는 private 가 아니면,
    생성자를 가질수 없습니다.
    (default : 생성자는 private 입니다.)
*/
fun evel(expr: Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> evel(expr.e1) + evel(expr.e2)
    NotANumber -> Double.NaN
    // 모든 경우의 수를 다룬 경우 else 절이 필요 없음.
}