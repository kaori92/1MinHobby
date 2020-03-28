package com.example.new1minhobby.activities

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup
import com.example.new1minhobby.CustomAdSize
import com.example.new1minhobby.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

open class AdActivity: Activity() {
    private lateinit var adView: AdView
    protected lateinit var adViewContainer: ViewGroup
    private var initialLayoutComplete = false

    private val customAdSize: CustomAdSize
        get() {
            return CustomAdSize.getInstance(windowManager, adViewContainer, this)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAds()
    }

    private fun setUpAds(){
        MobileAds.initialize(this)
        adView = AdView(this)
        adViewContainer.addView(adView)

        adViewContainer.viewTreeObserver.addOnGlobalLayoutListener {
            if (!initialLayoutComplete) {
                initialLayoutComplete = true
                loadBanner()
            }
        }
    }

    private fun loadBanner() {
        adView.adUnitId = resources.getString(R.string.ad_unit_id)

        val myAdSize = AdSize(customAdSize.customWidth, customAdSize.customHeight)
        adView.adSize = myAdSize

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device, e.g.,
        // "Use AdRequest.Builder.addTestDevice("ABCDE0123") to get test ads on this device."
        val adRequest = AdRequest
            .Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build()

        // Start loading the ad in the background.
        adView.loadAd(adRequest)
    }

    public override fun onPause() {
        adView.pause()
        super.onPause()
    }


    /** Called when returning to the activity  */
    public override fun onResume() {
        super.onResume()
        adView.resume()
    }

    /** Called before the activity is destroyed  */
    public override fun onDestroy() {
        adView.destroy()
        super.onDestroy()
    }

}