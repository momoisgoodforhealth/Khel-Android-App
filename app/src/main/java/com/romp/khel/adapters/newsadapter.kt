package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.R
import com.romp.khel.daateeee
import com.romp.khel.news



class newsadapter: RecyclerView.Adapter<news>() {

    var data= listOf<String>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): news {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.news_cardview, parent, false) as CardView
        return news(view)
    }

    override fun onBindViewHolder(holder: news, position: Int) {
        val item=data[position]
        holder.newstitle.text=item

    }

    override fun getItemCount()=data.size
}