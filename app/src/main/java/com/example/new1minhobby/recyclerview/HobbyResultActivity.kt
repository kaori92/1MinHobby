package com.example.new1minhobby.recyclerview

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.new1minhobby.HobbyMatcher
import com.example.new1minhobby.R
import com.example.new1minhobby.models.Hobby

class HobbyResultActivity : Activity(), HobbyAdapter.ItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var hobbies: List<Hobby>? = null

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hobby_result)

        hobbies = matchHobbies()

        viewManager = LinearLayoutManager(this)
        viewAdapter = HobbyAdapter( this, hobbies!!)

        recyclerView = findViewById<RecyclerView>(R.id.hobbies_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun matchHobbies(): List<Hobby>{
        val bundle: Bundle? = intent.extras
        val type: String = bundle?.get("type") as String
        val time: String = bundle?.get("time") as String
        val price:String = bundle?.get("price") as String

        val matcher = HobbyMatcher(type, time, price)
        val allHobbies = matcher.loadHobbies(this)
        return matcher.match(allHobbies)
    }

     override fun onItemClick(hobby: Hobby) {
        Log.d("TAG123", "hobby $hobby")
    }
}