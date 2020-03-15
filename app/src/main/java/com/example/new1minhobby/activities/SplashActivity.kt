package com.example.new1minhobby.activities

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.new1minhobby.R
import com.example.new1minhobby.SPLASH_DISPLAY_LENGTH_MS

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageView = findViewById<ImageView>(R.id.imageView)
        Glide
            .with(this)
            .asGif()
            .load(R.raw.splash)
            .listener(object : RequestListener<GifDrawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<GifDrawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("ERROR", "Exception loading gif: $e")
                    return true
                }

                override fun onResourceReady(
                    resource: GifDrawable?,
                    model: Any?,
                    target: Target<GifDrawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    startNextActivity()
                    return true
                }

            })
            .into(imageView)

//        Handler().postDelayed(this::startNextActivity, SPLASH_DISPLAY_LENGTH_MS)
    }

    private fun startNextActivity(){
        val intent = Intent(this, QuestionTypeActivity::class.java)
        startActivity(intent)
    }
}