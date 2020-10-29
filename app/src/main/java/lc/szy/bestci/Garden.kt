package lc.szy.bestci

import android.graphics.Canvas

class Garden {
    var bloomList = ArrayList<Bloom>()

    companion object {
        const val minPetalCount = 4
        const val maxPetalCount = 6
        const val minPetalStretch = 4f
        const val maxPetalStretch = 7f
        const val minGrowFactor = 0.1f
        const val maxGrowFactor = 0.2f
        const val minBloomRadius = 80
        const val maxBloomRadius = 100
        const val minRedColor = 128
        const val maxRedColor = 255
        const val minGreenColor = 0
        const val maxGreenColor = 128
        const val minBlueColor = 0
        const val maxBlueColor = 128
        const val opacity = 0.6f
    }
}