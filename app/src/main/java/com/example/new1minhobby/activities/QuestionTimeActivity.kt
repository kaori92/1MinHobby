package com.example.new1minhobby.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.new1minhobby.R

class QuestionTimeActivity() : Activity() {
    protected override fun onCreate(savedInstanceState : Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.question_time)
    }

    fun passValue(view: View) {
        val button: Button? = view as? Button
        val bundle: Bundle? = intent.extras
        val type = bundle?.get("type")

        val intent = Intent(this, QuestionMoneyActivity::class.java)
        intent.putExtra("time", button?.getTag().toString())
        intent.putExtra("type", type.toString())
        startActivity(intent)
    }
}
