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
    val ANIMATOR_DURATION = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
    }

    override fun onResume() {
        super.onResume()
        agreeBt.setOnClickListener {
            textSurface.reset()
            showText(textSurface)
            toast("看来你选了一个正确答案", ToastType.Success)
        }
        reconsiderBt.setOnClickListener {
            toast("你可要仔细考虑考虑哦", ToastType.Error)
        }
    }

    fun showText(textSurface: TextSurface) {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val firstSentence = createText("你知道吗？", paint, Align.SURFACE_CENTER)
        val secondSentence =
            createText("你还知道吗？", paint, Align.BOTTOM_OF or Align.CENTER_OF, firstSentence)
        val thirdSentence =
            createText("你还还知道吗？", paint, Align.BOTTOM_OF or Align.CENTER_OF, secondSentence)
        val fourthSentence =
            createText("你还还还知道吗？", paint, Align.BOTTOM_OF or Align.CENTER_OF, thirdSentence)
        val fifthSentence =
            createText("你还还还还知道吗？", paint, Align.BOTTOM_OF or Align.CENTER_OF, fourthSentence)
        val sixthSentence =
            createText("你还还还还还知道吗？", paint, Align.BOTTOM_OF or Align.CENTER_OF, fifthSentence)
        val seventhSentence =
            createText("你还还还还还还知道吗？", paint, Align.BOTTOM_OF or Align.CENTER_OF, sixthSentence)
        val eighthSentence =
            createText("你还还还还还还还知道吗？", paint, Align.BOTTOM_OF or Align.CENTER_OF, seventhSentence)
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
                ),
                Parallel(
                    TransSurface(ANIMATOR_DURATION, eighthSentence, Pivot.CENTER),
                    Slide.showFrom(Side.BOTTOM, eighthSentence, ANIMATOR_DURATION)
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