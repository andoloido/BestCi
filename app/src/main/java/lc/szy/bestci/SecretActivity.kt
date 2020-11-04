package lc.szy.bestci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_secret.*
import lc.szy.bestci.utils.ReverseAnimator

class SecretActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret)
    }

    override fun onResume() {
        super.onResume()
        ReverseAnimator.buildReverseAnimator(cardView1, reverseCardView1)
    }
}