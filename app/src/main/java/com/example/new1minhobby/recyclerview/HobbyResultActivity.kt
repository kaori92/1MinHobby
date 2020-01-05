package com.example.new1minhobby.recyclerview

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.new1minhobby.HobbyMatcher
import com.example.new1minhobby.R
import com.example.new1minhobby.models.Hobby

class HobbyResultActivity : Activity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    protected override fun onCreate(savedInstanceState : Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.hobby_result)

//        val filteredHobbies = matchHobbies()
        val filteredHobbies = listOf("a")

        viewManager = LinearLayoutManager(this)
        viewAdapter = HobbyAdapter( this, filteredHobbies)

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
}