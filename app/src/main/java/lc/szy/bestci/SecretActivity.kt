package lc.szy.bestci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_secret.*
import lc.szy.bestci.utils.ReverseAnimator

class SecretActivity : AppCompatActivity() {
    var isChuNvReversed = false
    var isShuiPingReversed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret)
        nextBt.alpha = 0f
        startBt.alpha = 0f
        titleTv.alpha = 0f
        startBt.animate().alpha(1f).setDuration(5000L).start()
        titleTv.animate().alpha(1f).setDuration(5000L).start()
        nextBt.setOnClickListener {
            startActivity(Intent(this, TextActivity::class.java))
        }
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                startBt.isClickable = false
                titleTv.animate().alpha(0f).setDuration(2000L).start()
                startBt.animate().alpha(0f).setDuration(2000L).start()
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                //no usage
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                ReverseAnimator.buildReverseAnimator(cardView1, reverseCardView1) {
                    isChuNvReversed = true
                    if (isChuNvReversed and isShuiPingReversed) {
                        nextBt.animate().alpha(1f).setDuration(2000L).start()
                    }
                }
                ReverseAnimator.buildReverseAnimator(cardView2, reverseCardView2)
                ReverseAnimator.buildReverseAnimator(cardView3, reverseCardView3)
                ReverseAnimator.buildReverseAnimator(cardView4, reverseCardView4)
                ReverseAnimator.buildReverseAnimator(cardView5, reverseCardView5)
                ReverseAnimator.buildReverseAnimator(cardView6, reverseCardView6)
                ReverseAnimator.buildReverseAnimator(cardView7, reverseCardView7)
                ReverseAnimator.buildReverseAnimator(cardView8, reverseCardView8)
                ReverseAnimator.buildReverseAnimator(cardView9, reverseCardView9)
                ReverseAnimator.buildReverseAnimator(cardView10, reverseCardView10)
                ReverseAnimator.buildReverseAnimator(cardView11, reverseCardView11)
                ReverseAnimator.buildReverseAnimator(cardView12, reverseCardView12) {
                    isShuiPingReversed = true
                    if (isChuNvReversed and isShuiPingReversed) {
                        nextBt.animate().alpha(1f).setDuration(2000L).start()
                    }
                }
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                //no usage
            }
        })
    }
}