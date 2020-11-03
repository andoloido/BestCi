package lc.szy.bestci.view.heart

import android.graphics.*

class Petal(val color: Int, startAngle: Float, angle: Float) {
    val stretchA = randomFloat(Garden.minPetalStretch, Garden.maxPetalStretch)
    val stretchB = randomFloat(Garden.minPetalStretch, Garden.maxPetalStretch)
    val growFactor = randomFloat(Garden.minGrowFactor, Garden.maxGrowFactor)
    var radius = 1f
    val endRadius = randomInt(Garden.minBloomRadius, Garden.maxBloomRadius)
    val point1 = PointF(0f, 1f).rotate(angleToRadian(startAngle))
    val point2 = point1.clone().rotate(angleToRadian(angle))
    var point3 = point1.clone() * (stretchA)
    var point4 = point2.clone() * (stretchB)


    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val path = Path()
    private lateinit var sweepGradientShader: LinearGradient

    var isFinished = false

    init {
        paint.strokeWidth = 10f
        paint.color = color
    }

    fun draw(canvas: Canvas) {
        if (radius < endRadius) radius += growFactor else isFinished = true
        path.moveTo(point1.x, point1.y)
        path.rCubicTo(
            point4.x * radius,
            point4.y * radius,
            point3.x * radius,
            point3.y * radius,
            point2.x,
            point2.y
        )
        //不要问我color1为什么要这么算，我只是一只小白兔
        sweepGradientShader = LinearGradient(
            point1.x * radius,
            point1.y * radius,
            point4.x * radius,
            point4.y * radius,
            color,
            -(color.toLong() - 0xff000000).toInt(),
            Shader.TileMode.REPEAT
        )
        paint.shader = sweepGradientShader
        canvas.drawPath(path, paint)
        path.reset()
    }
}