package com.example.new1minhobby.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.new1minhobby.R

class QuestionTypeActivity : AdActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        setTheme(R.style.splashScreenTheme)
        setContentView(R.layout.question_type)
        super.onCreate(savedInstanceState)
        startAnimation()
    }

    private fun startAnimation(){
    }

    fun passValue(view: View) {
        val button: Button? = view as? Button
        val intent = Intent(this, QuestionTimeActivity::class.java)
        intent.putExtra("type", button?.tag.toString())
        startActivity(intent)
    }
}
