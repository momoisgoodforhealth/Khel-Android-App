package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.romp.khel.R
import com.romp.khel.daateeee
import com.romp.khel.newsviewholder


class newsadapter: RecyclerView.Adapter<newsviewholder>() {

    var data= listOf<com.romp.khel.dataclass.news>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsviewholder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.news_cardview, parent, false) as CardView
        return newsviewholder(view)
    }

    override fun onBindViewHolder(holder: newsviewholder, position: Int) {
        val item=data[position]
        holder.newstitle.text=item.title
        holder.newstext.text=item.text
        Glide.with(holder.itemView).load(item.url).centerCrop().into(holder.newspic)
    }

    override fun getItemCount()=data.size
}