package com.example.new1minhobby

import android.app.Activity
import android.util.Log
import com.example.new1minhobby.models.Hobby

class HobbyMatcher {
    val fileName = "hobbies.csv"
    var category: String? = null
    var time: String? = null
    var price: String? = null
    var id = 0

    constructor(type: String, time: String, price: String) {
        this.category = type
        this.time = time
        this.price = price
    }

    fun match(allHobbies: MutableList<Hobby>): List<Hobby> {
        Log.d("TAG this", "$category $time $price")
        return allHobbies.filter {
            it.category == category && it.time == time && it.price == price
        }
    }

    fun loadHobbies(context: Activity): MutableList<Hobby> {
        val result = mutableListOf<Hobby>()

        val lineList = mutableListOf<String>()
        val hobbies = context.application.assets.open(fileName).bufferedReader().useLines { lines ->
            lines.forEach {

                val values: Array<String>? = it.split(",").toTypedArray()
                values?.let {
                    if (it.size == 4) {
                        val hobby = Hobby(id, it[0], it[1], it[2], it[3])
                        Log.d("TAG", hobby.toString())
                        result.add(hobby)
                    } else {
                        Log.e("ERROR", "Read a line containing less than 4 fields")
                    }
                    id++
                }
            }
        }
        return result
    }

}