package com.example.new1minhobby.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.new1minhobby.R

class QuestionTypeActivity : Activity() {
    protected override fun onCreate(savedInstanceState : Bundle?) {
        setTheme(R.style.splashScreenTheme)
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.question_type)
    }

    fun passValue(view: View) {
        val button: Button? = view as? Button
        val intent = Intent(this, QuestionTimeActivity::class.java)
        intent.putExtra("type", button?.tag.toString())
        startActivity(intent)
    }
}
