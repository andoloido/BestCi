package lc.szy.bestci.heart

import android.graphics.Canvas

class Bloom(val point: PointF, color: Int, petalCount: Int = 5) {

    val petalList = mutableListOf<Petal>()

    init {
        var startAngle = randomFloat(0f, 90f)
        val angle = 360f / petalCount
        for (i in 0 until petalCount ) {
            petalList.add(Petal(color, startAngle + angle * i, angle))
        }
        startAngle -= 30
        for (i in 0 until petalCount) {
            petalList.add(Petal(color, startAngle + angle * i, angle))
            startAngle += angle
        }
    }

    fun draw(canvas: Canvas) {
        canvas.save()
        canvas.translate(point.x, point.y)
        petalList.forEach { petal ->
            petal.draw(canvas)
        }
        canvas.restore()
    }
}