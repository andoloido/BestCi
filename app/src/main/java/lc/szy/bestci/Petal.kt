package lc.szy.bestci

import android.graphics.*
import android.util.Log
import java.lang.String

class Petal(val color: Int, startAngle: Int, angle: Int) {
    val stretchA = randomFloat(Garden.minPetalStretch, Garden.maxPetalStretch)
    val stretchB = randomFloat(Garden.minPetalStretch, Garden.maxPetalStretch)
    val growFactor = randomFloat(Garden.minGrowFactor, Garden.maxGrowFactor)
    var radius = 1f
    val endRadius = randomInt(Garden.minBloomRadius, Garden.maxBloomRadius)
    val point1 = Point(0f, 1f).rotate(angleToRadian(startAngle))
    val point2 = point1.clone().rotate(angleToRadian(angle))
    var point3 = point1.clone() * (stretchA)
    var point4 = point2.clone() * (stretchB)


    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val path = Path()
    val sweepGradientShader = LinearGradient(
        point1.x,
        point1.y,
        point4.x,
        point4.y,
        color,
        randomArgb(
            Garden.minRedColor,
            Garden.maxRedColor,
            Garden.minGreenColor,
            Garden.maxGreenColor,
            Garden.minBlueColor,
            Garden.maxBlueColor,
            Garden.opacity
        ),
        Shader.TileMode.REPEAT
    )
    var isFinished = false

    init {
        paint.strokeWidth = 10f
        paint.color = color
        paint.shader = sweepGradientShader
    }

    fun draw(canvas: Canvas) {
        val hexColor1 = String.format(
            "#%06X",
            0xFFFFFF and color
        )
        val hexColor2 = String.format(
            "#%06X",
            0xFFFFFF and (color.and(
                0x00ffffff
            ))
        )

        Log.i(
            "PetalColor", "before" + hexColor1 + "after" + hexColor2
        )
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
        canvas.drawPath(path, paint)
        path.reset()
    }
}