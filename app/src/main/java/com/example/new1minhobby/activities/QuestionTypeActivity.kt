package com.example.new1minhobby.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.example.new1minhobby.R

class QuestionTypeActivity : AdActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        setContentView(R.layout.question_type)
        adViewContainer = findViewById<LinearLayout>(R.id.adViewContainer)
        super.onCreate(savedInstanceState)
    }

    fun passValue(view: View) {
        val button: Button? = view as? Button
        val intent = Intent(this, QuestionTimeActivity::class.java)
        intent.putExtra("type", button?.tag.toString())
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }

}
