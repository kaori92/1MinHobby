package com.example.new1minhobby

import android.app.Activity
import android.util.Log
import com.example.new1minhobby.data.Hobby

class HobbyMatcher(type: String, time: String, price: String) {
    val fileName = "hobbies.tsv"
    val columns = 6
    var category: String? = type
    var time: String? = time
    var price: String? = price

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

                val values: Array<String>? = it.split(DELIMITER).toTypedArray()
                println("TAG123 values "+values.toString()+ " it: "+it.toString())
                values?.let {
                    if (it.size == columns) {
                        val hobby = Hobby(it[0], it[1], it[2], it[3], it[4], it[5])
                        Log.d("TAG", hobby.toString())
                        result.add(hobby)
                    } else {
                        Log.e("ERROR", "Read a line containing less than $columns fields")
                    }
                }
            }
        }
        return result
    }

}