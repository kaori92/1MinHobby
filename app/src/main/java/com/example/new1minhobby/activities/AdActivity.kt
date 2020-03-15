package com.example.new1minhobby.activities

import android.app.Activity
import android.os.Bundle
import com.example.new1minhobby.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

open class AdActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAds()
    }

    private fun setUpAds(){
        MobileAds.initialize(this)
        val adView: AdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }
}