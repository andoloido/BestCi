package lc.szy.bestci.view.rainbow

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import lc.szy.bestci.utils.dp
import lc.szy.bestci.view.heart.PointF

class RainbowView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    val pink = "#eb7897"
    val purple = "#7e57c2"
    val orange = "#f15a22"
    val blue = "#33a3dc"
    val green = "#71b30e"
    val brown = "#eebe87"

    var maxRadius = 0f
    val strokeWidth = 10f.dp
    var radius1 = 0f
    var radius2 = 0f
    var radius3 = 0f
    var radius4 = 0f
    var radius5 = 0f
    var radius6 = 0f
    lateinit var centerPoint: PointF

    var sweepAngle = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f.dp
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        val size = Math.min(w, h * 2)
        centerPoint = PointF(w / 2f, h / 1f)
        maxRadius = size * 4 / 9f
        radius1 = maxRadius
        radius2 = maxRadius - strokeWidth * 1
        radius3 = maxRadius - strokeWidth * 2
        radius4 = maxRadius - strokeWidth * 3
        radius5 = maxRadius - strokeWidth * 4
        radius6 = maxRadius - strokeWidth * 5
    }

    override fun onDraw(canvas: Canvas) {
        canvas.run {
            drawRainbowLine(pink, radius1, sweepAngle)
            drawRainbowLine(orange, radius2, sweepAngle)
            drawRainbowLine(brown, radius3, sweepAngle)
            drawRainbowLine(green, radius4, sweepAngle)
            drawRainbowLine(blue, radius5, sweepAngle)
            drawRainbowLine(purple, radius6, sweepAngle)
        }
    }

    fun Canvas.drawRainbowLine(color: String, radius: Float, sweepAngle: Float = 180f) {
        paint.color = Color.parseColor(color)
        drawArc(
            centerPoint.x - radius,
            centerPoint.y - radius,
            centerPoint.x + radius,
            centerPoint.y + radius,
            180f,
            sweepAngle,
            false,
            paint
        )
    }
}