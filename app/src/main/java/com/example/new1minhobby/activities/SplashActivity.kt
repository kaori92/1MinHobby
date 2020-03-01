package com.example.new1minhobby.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.new1minhobby.R
import com.example.new1minhobby.SPLASH_DISPLAY_LENGTH_MS

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageView = findViewById<ImageView>(R.id.imageView)
        Glide.with(this).asGif().load(R.raw.splash).into(imageView)

        Handler().postDelayed(this::startNextActivity, SPLASH_DISPLAY_LENGTH_MS)
    }

    private fun startNextActivity(){
        val intent = Intent(this, QuestionTypeActivity::class.java)
        startActivity(intent)
    }
}