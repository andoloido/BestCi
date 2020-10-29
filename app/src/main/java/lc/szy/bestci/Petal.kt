package lc.szy.bestci

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path

class Petal(color: Int, startAngle: Int, angle: Int) {
    val stretchA = 4f
    val stretchB = 4f
    val growFactor = 0.1f
    var isFinished = false
    var radius = 1f
    val point1 = Point(0f, 1f).rotate(angleToRadian(startAngle))
    val point2 = point1.clone().rotate(angleToRadian(angle))
    var point3 = point1.clone() * (stretchA)
    var point4 = point2.clone() * (stretchB)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.strokeWidth = 1f
        paint.style = Paint.Style.STROKE
        paint.color = color
    }

    fun draw(canvas: Canvas) {
        if (radius < 20f) radius += growFactor else isFinished = true
        val path = Path()
        path.moveTo(point1.x, point1.y)
        path.rCubicTo(
            point4.x * radius,
            point4.y * radius,
            point3.x * radius,
            point3.y * radius,
            point2.x,
            point2.y
        )
        canvas.drawPath(path, paint)
    }
}