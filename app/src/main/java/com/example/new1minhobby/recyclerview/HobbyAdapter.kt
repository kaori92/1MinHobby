package com.example.new1minhobby.recyclerview

import com.example.new1minhobby.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.new1minhobby.models.Hobby

class HobbyAdapter internal constructor(
    context: HobbyResultActivity,
    data: List<Hobby>
) :
    RecyclerView.Adapter<ViewHolder>() {
    private val data: List<Hobby>
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var clickListener: ItemClickListener? = null
    val activity = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.hobby_list_item, parent, false)
        return MyViewHolder(view, activity)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder constructor(itemView: View, context: HobbyResultActivity) : ViewHolder(itemView),
        View.OnClickListener {

        var myTextView: TextView
        val innerContext = context

        override fun onClick(view: View?) {
            Log.d("TAG12345", "textview ${myTextView.text} view $view position ${getAdapterPosition()}")
            innerContext.onItemClick(getItem(getAdapterPosition()))
        }

        init {
            myTextView = itemView.findViewById(R.id.hobby_text_view)
            itemView.setOnClickListener(this)
        }
    }

    fun getItem(id: Int): Hobby {
        return data[id]
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        clickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(hobby: Hobby)
    }

    init {
        this.data = data
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hobby = data[position]
        (holder as MyViewHolder).myTextView.text = hobby.name.toUpperCase()
    }
}