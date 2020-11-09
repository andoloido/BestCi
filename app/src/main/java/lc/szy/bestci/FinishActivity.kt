package lc.szy.bestci

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
    }

    override fun onResume() {
        super.onResume()
         ObjectAnimator.ofFloat(rainbowView, "sweepAngle", 180f).run {
             interpolator = LinearInterpolator()
             duration = 5000L
             start()
         }
    }
}