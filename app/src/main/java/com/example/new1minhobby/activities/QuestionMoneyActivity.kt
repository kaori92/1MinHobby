package com.example.new1minhobby.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.new1minhobby.R
import com.example.new1minhobby.recyclerview.HobbyResultActivity

class QuestionMoneyActivity() : Activity() {
    protected override fun onCreate(savedInstanceState : Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.question_money)
    }

    fun passValue(view: View) {
        val button: Button? = view as? Button

        val bundle: Bundle? = intent.extras
        val type = bundle?.get("type").toString()
        val time = bundle?.get("time").toString()

        val intent = Intent(this, HobbyResultActivity::class.java)
        intent.putExtra("price", button?.tag.toString())
        intent.putExtra("type", type)
        intent.putExtra("time", time)

        startActivity(intent)
    }
}
