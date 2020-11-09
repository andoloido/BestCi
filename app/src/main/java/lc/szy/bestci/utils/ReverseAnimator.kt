package lc.szy.bestci.utils

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.animation.addListener


class ReverseAnimator(view1: View, view2: View, reverseListener: (() -> Unit)? = null) {
    companion object {
        fun buildReverseAnimator(view1: View, view2: View, reverseListener: (() -> Unit)? = null) {
            ReverseAnimator(view1, view2, reverseListener)
        }
    }

    val animator1: ObjectAnimator =
        ObjectAnimator.ofFloat(view1, View.ROTATION_Y, 0f, 90f).setDuration(500L)
    val animator1Reverse: ObjectAnimator =
        ObjectAnimator.ofFloat(view1, View.ROTATION_Y, 90f, 0f).setDuration(500L)
    val animator2: ObjectAnimator =
        ObjectAnimator.ofFloat(view2, View.ROTATION_Y, 90f, 180f).setDuration(500L)
    val animator2Reverse: ObjectAnimator =
        ObjectAnimator.ofFloat(view2, View.ROTATION_Y, 180f, 90f).setDuration(500L)

    init {
        animator1.interpolator = LinearInterpolator()
        animator2.interpolator = LinearInterpolator()
        animator1.addListener(onEnd = {
            animator2.start()
        })
        animator2Reverse.addListener(onEnd = {
            animator1Reverse.start()
        })
        view1.setOnClickListener {
            animator1.start()
            reverseListener?.invoke()
        }
        view2.setOnClickListener {
            animator2Reverse.start()
        }
    }
}