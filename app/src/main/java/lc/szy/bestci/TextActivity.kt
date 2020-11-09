package lc.szy.bestci

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.os.Looper
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_text.*
import lc.szy.bestci.utils.ToastType
import lc.szy.bestci.utils.toast
import su.levenetc.android.textsurface.Text
import su.levenetc.android.textsurface.TextBuilder
import su.levenetc.android.textsurface.TextSurface
import su.levenetc.android.textsurface.animations.*
import su.levenetc.android.textsurface.contants.Align
import su.levenetc.android.textsurface.contants.Pivot
import su.levenetc.android.textsurface.contants.Side

class TextActivity : AppCompatActivity() {
    val ANIMATOR_DURATION = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
    }

    override fun onResume() {
        super.onResume()
        textSurface.reset()
        showText(textSurface)
        agreeBt.setOnClickListener {
            toast("谢谢你的信任，余生多多指教", ToastType.Success)
        }
    }

    fun showText(textSurface: TextSurface) {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val firstSentence = createText("我想只有   这几句话", paint, Align.SURFACE_CENTER)
        val secondSentence =
            createText("才能表达一些我的心意", paint, Align.BOTTOM_OF or Align.CENTER_OF, firstSentence)
        val thirdSentence =
            createText("Би чамд хайртай", paint, Align.BOTTOM_OF or Align.CENTER_OF, secondSentence)
        val fourthSentence =
            createText("Я люблю тебя", paint, Align.BOTTOM_OF or Align.CENTER_OF, thirdSentence)
        val fifthSentence =
            createText("爱している", paint, Align.BOTTOM_OF or Align.CENTER_OF, fourthSentence)
        val sixthSentence =
            createText("I love you", paint, Align.BOTTOM_OF or Align.CENTER_OF, fifthSentence)
        val seventhSentence =
            createText("我爱你", paint, Align.BOTTOM_OF or Align.CENTER_OF, sixthSentence)
        textSurface.play(
            Sequential(
                ShapeReveal.create(
                    firstSentence,
                    ANIMATOR_DURATION,
                    SideCut.show(WindowInsets.Side.LEFT),
                    false
                ),
                Parallel(
                    TransSurface(ANIMATOR_DURATION, secondSentence, Pivot.CENTER),
                    ShapeReveal.create(
                        secondSentence, ANIMATOR_DURATION, SideCut.show(
                            Side.LEFT
                        ), false
                    )
                ),
                Parallel(
                    TransSurface(ANIMATOR_DURATION, thirdSentence, Pivot.CENTER),
                    Rotate3D.showFromSide(thirdSentence, ANIMATOR_DURATION, Pivot.TOP)
                ),
                Parallel(
                    TransSurface(ANIMATOR_DURATION, fourthSentence, Pivot.CENTER),
                    Rotate3D.showFromSide(fourthSentence, ANIMATOR_DURATION, Pivot.TOP)
                ),
                Parallel(
                    TransSurface(ANIMATOR_DURATION, fifthSentence, Pivot.CENTER),
                    Rotate3D.showFromSide(fifthSentence, ANIMATOR_DURATION, Pivot.TOP)
                ),
                Parallel(
                    TransSurface(ANIMATOR_DURATION, sixthSentence, Pivot.CENTER),
                    Rotate3D.showFromSide(sixthSentence, ANIMATOR_DURATION, Pivot.TOP)
                ),
                Parallel(
                    TransSurface(ANIMATOR_DURATION, seventhSentence, Pivot.CENTER),
                    Slide.showFrom(Side.BOTTOM, seventhSentence, ANIMATOR_DURATION)
                )
            )
        )
    }

    fun createText(
        sentence: String,
        paint: Paint,
        position: Int,
        alignText: Text? = null,
        size: Float = 22f,
        alpha: Int = 0,
        color: Int = Color.BLACK
    ): Text {
        return if (alignText == null) TextBuilder.create(sentence).setPaint(paint).setSize(size)
            .setAlpha(alpha).setColor(color).setPosition(position).build() else TextBuilder.create(
            sentence
        ).setPaint(paint).setSize(size)
            .setAlpha(alpha).setColor(color).setPosition(position, alignText).build()
    }

}