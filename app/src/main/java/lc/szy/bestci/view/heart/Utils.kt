package lc.szy.bestci.view.heart

import android.graphics.Color
import kotlin.math.*

fun getHeartPoint(angle: Float, offsetX: Int, offsetY: Int): PointF {
    val radian = Math.PI * angle / 180
    val x = (20 * (16 * sin(radian).pow(3.0))).toFloat()
    val y = (-20 * (13 * cos(radian) - 5 * cos(2 * radian) -
            2 * cos(3 * radian) - cos(4 * radian))).toFloat()
    return PointF(offsetX + x, offsetY + y)
}

const val CIRCLE = 2f * Math.PI

fun argb(r: Int, g: Int, b: Int, a: Int) = Color.argb(a, r, g, b)


fun randomInt(min: Int, max: Int) = floor(Math.random() * (max - min + 1)).toInt() + min


fun randomFloat(min: Float, max: Float) = (Math.random() * (max - min) + min).toFloat()

fun angleToRadian(angle: Float) =  (Math.PI / 180f * angle).toFloat()

fun randomArgb(
    rMin: Int,
    rMax: Int,
    gMin: Int,
    gMax: Int,
    bMin: Int,
    bMax: Int,
    a: Float
): Int {
    val r = randomFloat(rMin.toFloat(), rMax.toFloat()).toDouble().roundToInt()
    val g = randomFloat(rMin.toFloat(), rMax.toFloat()).toDouble().roundToInt()
    val b = randomFloat(rMin.toFloat(), rMax.toFloat()).toDouble().roundToInt()
    val limit = 5
    return if (abs(r - g) <= limit && abs(g - b) < limit && abs(b - r) < limit) {
        randomArgb(rMin, rMax, gMin, gMax, bMin, bMax, a)
    } else {
        argb(r, g, b, (a * 255).toInt())
    }
}