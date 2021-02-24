package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.R
import com.romp.khel.daateeee
import com.romp.khel.datecardview

class dateLTPadapter: RecyclerView.Adapter<datecardview>() {

    var data= listOf<String>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): datecardview {val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.date_cardview, parent, false) as CardView
        return datecardview(view)
    }

    override fun onBindViewHolder(holder: datecardview, position: Int) {
        val item=data[position]
        holder.dateval.text=item

        holder.itemView.setOnClickListener {
            daateeee.value=item

        }
    }

    override fun getItemCount()=data.size
}