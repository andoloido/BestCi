package lc.szy.bestci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_text.*

class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
    }

    override fun onResume() {
        super.onResume()
        retryBt.setOnClickListener {
            textSurface.reset()
            Sample.play(textSurface, assets)
        }
    }
}