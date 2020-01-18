package com.example.new1minhobby.activities

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.new1minhobby.R
import com.example.new1minhobby.data.Hobby
import com.google.gson.Gson

class HobbyDetailActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hobby_detail)

        val bundle: Bundle? = intent.extras
        val hobby = Gson().fromJson(bundle?.get("hobby").toString(), Hobby::class.java)
        Log.d("TAG123", "decoded hobby $hobby")

    }
}