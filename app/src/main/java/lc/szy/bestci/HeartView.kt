package lc.szy.bestci

import android.content.Context
import android.graphics.Canvas
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import kotlin.math.ceil

class HeartView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    val bloomCount = 100
    val bloomList = ArrayList<Bloom>(bloomCount)

    val bloomAngle = 360f / bloomCount
    var curAngle = 0f

    var stopInvalidate = false
    var thread = object : Thread() {
        override fun run() {
            while (true) {
                if (stopInvalidate) return
                sleep(1000 / 60)
                postInvalidate()
            }
        }
    }

    init {
        thread.start()
    }

    override fun onDraw(canvas: Canvas) {
        for (i in 0 until Math.min(ceil((curAngle / bloomAngle).toDouble()).toInt(), bloomList.size)) {
            if (i == bloomList.size - 1) {
                if (bloomList[i].petalList.last().isFinished) {
                    stopInvalidate = true
                }
            }
            bloomList[i].draw(canvas)
        }
        curAngle += 2f
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        val offsetX = w / 2
        val offsetY = h / 2
        for (i in 0 until bloomCount) {
            val point = getHeartPoint(bloomAngle * i, offsetX, offsetY)
            if (bloomList.isNotEmpty()) {
                val lastPoint = bloomList.last().point
                val distance = Math.sqrt(Math.pow(lastPoint.x - point.x.toDouble(), 2.0) + Math.pow(lastPoint.y - point.y.toDouble(), 2.0))
                //别问我为什么要这么算，我只是一只小白兔
                if (distance < Garden.maxBloomRadius * Garden.maxPetalStretch / 1.3) continue
            }
            bloomList.add(
                Bloom(
                    point,
                    randomArgb(
                        Garden.minRedColor,
                        Garden.maxRedColor,
                        Garden.minGreenColor,
                        Garden.maxGreenColor,
                        Garden.minBlueColor,
                        Garden.maxBlueColor,
                        Garden.opacity
                    ),
                    randomInt(Garden.minPetalCount, Garden.maxPetalCount)
                )
            )
        }
    }
}
