package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.R
import com.romp.khel.daateeee
import com.romp.khel.datecardview
import com.romp.khel.stealthedeal

class StealTheDealAdapter: RecyclerView.Adapter<stealthedeal>()  {

    var data= listOf<String>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): stealthedeal {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.stealthedeal_cardview, parent, false) as CardView
        return stealthedeal(view)
    }

    override fun onBindViewHolder(holder: stealthedeal, position: Int) {
        val item=data[position]
        holder.venuename.text=item

        holder.itemView.setOnClickListener {
            daateeee.value=item
        }
    }

    override fun getItemCount()=data.size
}