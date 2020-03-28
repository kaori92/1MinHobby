package com.example.new1minhobby.activities

import android.R.attr.path
import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.VideoView
import com.example.new1minhobby.R


class SplashActivity : Activity() {
    private lateinit var videoView: VideoView
    private var stopPosition = 0
    private var displayed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        videoView = findViewById(R.id.videoView)
        showSplash()
    }

    override fun onPause() {
        super.onPause()

        stopPosition = videoView.currentPosition
        videoView.pause()
    }

    override fun onResume() {
        super.onResume()

        if(displayed){
            startNextActivity()
        } else {
            videoView.seekTo(stopPosition)
            videoView.resume()
        }
    }

    private fun showSplash() {
        val uriPath = "android.resource://$packageName/raw/splash_video"
        val uri = Uri.parse(uriPath)
        videoView.setVideoURI(uri)
        videoView.requestFocus()

        videoView.setOnErrorListener { _, what, extra ->
            Log.e("ERROR", "Error loading splash screen video! $what $extra")
            startNextActivity()
            true
        }

        videoView.setOnCompletionListener {
            displayed = true
            startNextActivity()
        }

        videoView.start()
    }

    private fun startNextActivity() {
        val intent = Intent(this, QuestionTypeActivity::class.java)
        startActivity(intent)
    }
}