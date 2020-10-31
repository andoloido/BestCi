package lc.szy.bestci.heart

import kotlin.math.cos
import kotlin.math.sin

data class PointF(var x: Float, var y: Float) {
    fun rotate(radian: Float): PointF {
        val tempX = x
        val tempY = y
        x = (cos(radian) * tempX - sin(radian) * tempY)
        y = (sin(radian) * tempX + cos(radian) * tempY)
        return this
    }

    operator fun times(times: Float): PointF {
        x *= times
        y *= times
        return this
    }

    fun clone() = PointF(x, y)
}