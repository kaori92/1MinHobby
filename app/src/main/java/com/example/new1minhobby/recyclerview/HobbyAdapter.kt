package com.example.new1minhobby.recyclerview

import com.example.new1minhobby.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.new1minhobby.activities.HobbyListActivity
import com.example.new1minhobby.data.Hobby

class HobbyAdapter internal constructor(
    context: HobbyListActivity,
    hobbies: List<Hobby>
) :
    RecyclerView.Adapter<ViewHolder>() {
    private val hobbies: List<Hobby> = hobbies
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val activity = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.hobby_list_item, parent, false)
        return MyViewHolder(view, activity)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    inner class MyViewHolder constructor(itemView: View, context: HobbyListActivity) : ViewHolder(itemView),
        View.OnClickListener {
        private var cardView = itemView.findViewById<CardView>(R.id.card_view)
        var myTextView: TextView = cardView.findViewById(R.id.hobby_text_view)
        private val innerContext = context

        override fun onClick(view: View?) {
            Log.d("TAG12345", "textview ${myTextView.text} view $view position ${getAdapterPosition()}")
            innerContext.onItemClick(getItem(adapterPosition))
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

    fun getItem(id: Int): Hobby {
        return hobbies[id]
    }

    interface ItemClickListener {
        fun onItemClick(hobby: Hobby)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hobby = hobbies[position]
        (holder as MyViewHolder).myTextView.text = hobby.name.toUpperCase()
    }
}