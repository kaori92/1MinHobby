package com.example.new1minhobby

import android.content.Context
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.view.WindowManager
import com.google.android.gms.ads.AdSize

class CustomAdSize private constructor(windowManager: WindowManager,
                                 adViewContainer: ViewGroup,
                                 context: Context) {
    var customWidth: Int
    var customHeight: Int

    init {
        val display = windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)

        val density = outMetrics.density

        var adWidthPixels = adViewContainer.width.toFloat()
        if (adWidthPixels == 0f) {
            adWidthPixels = outMetrics.widthPixels.toFloat()
        }

        val adWidth = (adWidthPixels / density).toInt()
        val adSize = AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth)
        customWidth = adSize.width
        customHeight = adSize.height
    }

    companion object : SingletonHolder<CustomAdSize, WindowManager, ViewGroup, Context>(::CustomAdSize)
}