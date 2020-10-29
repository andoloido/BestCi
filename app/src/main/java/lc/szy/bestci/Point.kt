package lc.szy.bestci

import kotlin.math.cos
import kotlin.math.sin

data class Point(var x: Float, var y: Float) {
    fun rotate(radian: Float): Point {
        x = (cos(radian) * x - sin(radian) * y)
        y = (sin(radian) * x + cos(radian) * y)
        return this
    }

    operator fun times(times: Float): Point {
        x *= times
        y *= times
        return this
    }

    fun clone() = Point(x, y)
}