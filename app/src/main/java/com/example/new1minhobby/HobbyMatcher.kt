package com.example.new1minhobby

import android.app.Activity
import android.util.Log
import com.example.new1minhobby.data.Hobby

class HobbyMatcher {
    val fileName = "hobbies.tsv"
    val columns = 6
    val delimiter = "\\t"
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

        var result =  allHobbies.filter {
            it.category == category && it.time == time && it.price == price
        }

        if(result.isEmpty()){
            result =  allHobbies.filter {
                it.category == category && (it.time == time || it.price == price)
            }
        }

        if(result.isEmpty()){
            result =  allHobbies.filter {
                it.category == category || it.time == time || it.price == price
            }
        }

        return result
    }

    fun loadHobbies(context: Activity): MutableList<Hobby> {
        val result = mutableListOf<Hobby>()

        context.application.assets.open(fileName).bufferedReader().useLines { lines ->
            lines.forEach {

                val values: Array<String>? = it.split(delimiter).toTypedArray()
                values?.let {
                    if (it.size == columns) {
                        val hobby = Hobby(id, it[0], it[1], it[2], it[3], it[4], it[5])
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