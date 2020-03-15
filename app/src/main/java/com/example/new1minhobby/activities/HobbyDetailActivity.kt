package com.example.new1minhobby.activities

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import com.example.new1minhobby.R
import com.example.new1minhobby.data.Hobby
import com.google.gson.Gson

class HobbyDetailActivity: AdActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.hobby_detail)
        adViewContainer = findViewById<LinearLayout>(R.id.adViewContainer)
        super.onCreate(savedInstanceState)

        val bundle: Bundle? = intent.extras
        val hobby = Gson().fromJson(bundle?.get("hobby").toString(), Hobby::class.java)
        Log.d("TAG123", "decoded hobby $hobby")

        val nameTextView = findViewById<TextView>(R.id.name_text_view)
        val descriptionTextView = findViewById<TextView>(R.id.description_text_view)
        val benefit1TextView = findViewById<TextView>(R.id.benefit1_text_view)
        val benefit2TextView = findViewById<TextView>(R.id.benefit2_text_view)
        val benefit3TextView = findViewById<TextView>(R.id.benefit3_text_view)

        nameTextView.text = hobby.name.toUpperCase()
        descriptionTextView.text = hobby.description
        val benefits = hobby.getBenefits()

        if(benefits.isNotEmpty() && benefits.size >= 3){
            benefit1TextView.text = " - " + benefits[0]
            benefit2TextView.text = " - " + benefits[1]
            benefit3TextView.text = " - " + benefits[2]
        } else {
            Log.e("TAG123", "hobby $hobby has less than 3 benefits! Benefits: $benefits")
        }
    }
}