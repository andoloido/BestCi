package lc.szy.bestci

import android.graphics.Canvas

class Garden {
    var bloomList = ArrayList<Bloom>()

    companion object {
        const val minPetalCount = 8
        const val maxPetalCount = 15
        const val minPetalStretch = 2f
        const val maxPetalStretch = 3.5f
        const val minGrowFactor = 1f
        const val maxGrowFactor = 1.1f
        const val minBloomRadius = 8
        const val maxBloomRadius = 10
        const val minRedColor = 128
        const val maxRedColor = 255
        const val minGreenColor = 0
        const val maxGreenColor = 128
        const val minBlueColor = 0
        const val maxBlueColor = 128
        const val opacity = 50f
    }
}