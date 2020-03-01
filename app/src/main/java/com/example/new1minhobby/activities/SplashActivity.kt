package com.example.new1minhobby.activities

import android.app.Activity
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.core.os.postDelayed
import com.example.new1minhobby.R


class SplashActivity : Activity() {
    private lateinit var animation: AnimationDrawable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        
        val imageView =
            findViewById<View>(R.id.imageView2) as ImageView // Declare an imageView to show the animation.
        imageView.setBackgroundResource(R.drawable.splash_screen_animation)
        animation = imageView.background as AnimationDrawable
    }

    override fun onResume() {
        super.onResume()

        animation.start()

//        val intent = Intent(this, QuestionTypeActivity::class.java)
        checkAnimationStatus(50, animation)
    }

    /**
     * check the animation status recursively, keep the animation until it reach the last frame.
     *
     * @param time              period of animation
     * @param animationDrawable animation list
     */
    private fun checkAnimationStatus(
        time: Int,
        animationDrawable: AnimationDrawable
    ) {
        val handler = Handler()
        handler.postDelayed(Runnable {
            if (animationDrawable.current !== animationDrawable.getFrame(animationDrawable.numberOfFrames - 1)) checkAnimationStatus(
                time,
                animationDrawable
            ) else finish()
        }, time.toLong())
    }
}