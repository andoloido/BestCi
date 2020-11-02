package lc.szy.bestci

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val endTime: Long
    val startTime: Long = System.currentTimeMillis()

    init {
        val calendar = Calendar.getInstance().apply {
            clear()
            set(Calendar.YEAR, 2020)
            //10表示11月
            set(Calendar.MONTH, 10)
            set(Calendar.DATE, 2)
            set(Calendar.HOUR_OF_DAY, 11)
            set(Calendar.MINUTE, 39)
            set(Calendar.SECOND, 50)
        }
        endTime = calendar.time.time
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (endTime - startTime > 0) {
            countDownTimer.start()
            startBt.setOnClickListener {
                //  Sample.play(textSurface, assets)
                toastLong("心急吃不了热豆腐，更可怕的是可能找不到好的男朋友哦")
            }
        } else {
            timeUp()
        }

    }

    val countDownTimer = object : CountDownTimer(endTime - startTime, 1000L) {
        override fun onTick(millisUntilFinished: Long) {
            val hour = millisUntilFinished / ((1000 * 60 * 60))
            val minute = millisUntilFinished / (1000 * 60) - hour * 60
            val second = millisUntilFinished / 1000 - hour * 60 * 60 - minute * 60
            val hourText = if (hour < 10) "0${hour}" else "$hour"
            val minuteText = if (minute < 10) "0${minute}" else "$minute"
            val secondText = if (second < 10) "0${second}" else "$second"
            countdownTv.text = "${hour}：${minuteText}：${secondText}"

        }

        override fun onFinish() {
            timeUp()
        }
    }

    private fun timeUp() {
        tipTv.visibility = View.GONE
        countdownTv.visibility = View.GONE
        heartView.visibility = View.VISIBLE
        heartView.start()
        startBt.text = "看看这小子还准备了啥"
        startBt.setOnClickListener {
            startActivity(Intent(this@MainActivity, TextActivity::class.java))
        }
    }
}