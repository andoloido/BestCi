package lc.szy.bestci

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.android.synthetic.main.activity_main.*
import lc.szy.bestci.utils.getCalendar
import java.util.*

class FinishActivity : AppCompatActivity() {
    lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        countDownTimer.start()
        calendar = getCalendar(2020, 11, 11, 11, 11, 11)
    }

    override fun onResume() {
        super.onResume()
        ObjectAnimator.ofFloat(rainbowView, "sweepAngle", 180f).run {
            interpolator = LinearInterpolator()
            duration = 5000L
            start()
        }
    }

    val countDownTimer = object : CountDownTimer(Long.MAX_VALUE, 1000L) {
        override fun onTick(millisUntilFinished: Long) {
            val interval = System.currentTimeMillis() - calendar.time.time
            val day = interval / (1000 * 60 * 60 * 24)
            val hour = (interval / (1000 * 60 * 60)) - day * 24
            val minute = (interval / (1000 * 60)) - day * 24 * 60 - hour * 60
            val second =
                (interval / (1000)) - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60
            line2LeftTv.text = "$day"
            line3LeftTv.text = "$hour"
            line4LeftTv.text = "$minute"
            line5LeftTv.text = "$second"
        }

        override fun onFinish() {
            //no usage
        }
    }
}