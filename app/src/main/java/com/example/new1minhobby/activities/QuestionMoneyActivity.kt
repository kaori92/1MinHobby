package com.example.new1minhobby.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.example.new1minhobby.R

class QuestionMoneyActivity() : AdActivity() {
    protected override fun onCreate(savedInstanceState : Bundle?) {
        setContentView(R.layout.question_money)
        adViewContainer = findViewById<LinearLayout>(R.id.adViewContainer)

        super.onCreate(savedInstanceState)
    }

    fun passValue(view: View) {
        val button: Button? = view as? Button

        val bundle: Bundle? = intent.extras
        val type = bundle?.get("type").toString()
        val time = bundle?.get("time").toString()

        val intent = Intent(this, HobbyListActivity::class.java)
        intent.putExtra("price", button?.tag.toString())
        intent.putExtra("type", type)
        intent.putExtra("time", time)

        startActivity(intent)
    }
}
