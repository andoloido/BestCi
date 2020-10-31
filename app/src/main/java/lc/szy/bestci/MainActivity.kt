package lc.szy.bestci

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity.TOP
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import su.levenetc.android.textsurface.Text
import su.levenetc.android.textsurface.TextBuilder
import su.levenetc.android.textsurface.animations.Alpha
import su.levenetc.android.textsurface.animations.Delay
import su.levenetc.android.textsurface.animations.Sequential
import su.levenetc.android.textsurface.animations.Slide
import su.levenetc.android.textsurface.contants.Align
import su.levenetc.android.textsurface.contants.Side

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Sample.play(textSurface, assets)
        startBt.setOnClickListener {
        }
    }
}