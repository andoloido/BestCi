package lc.szy.bestci

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.UiThread
import kotlin.math.ceil

class HeartView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var offsetX = 0
    var offsetY = 0

    val bloomCount = 10
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
                if (bloomList[i].petalList[4].isFinished) {
                    stopInvalidate = true
                }
            }
            bloomList[i].draw(canvas)
        }
        curAngle += 2f
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        offsetX = w / 2
        offsetY = h / 2
        for (i in 0 until bloomCount) {
            val point = getHeartPoint(bloomAngle * i, offsetX, offsetY)
            bloomList.add(Bloom(point, Color.RED))
        }
    }
}
