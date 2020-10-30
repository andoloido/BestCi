package lc.szy.bestci

import kotlin.math.cos
import kotlin.math.sin

data class Point(var x: Float, var y: Float) {
    fun rotate(radian: Float): Point {
        val tempX = x
        val tempY = y
        x = (cos(radian) * tempX - sin(radian) * tempY)
        y = (sin(radian) * tempX + cos(radian) * tempY)
        return this
    }

    operator fun times(times: Float): Point {
        x *= times
        y *= times
        return this
    }

    fun clone() = Point(x, y)
}