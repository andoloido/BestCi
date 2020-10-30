package lc.szy.bestci

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import kotlin.math.ceil

class HeartView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    val bloomCount = 30
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
        for (i in 0 until Math.min(ceil((curAngle / bloomAngle).toDouble()).toInt(), bloomCount)) {
            if (i == bloomCount - 1) {
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
