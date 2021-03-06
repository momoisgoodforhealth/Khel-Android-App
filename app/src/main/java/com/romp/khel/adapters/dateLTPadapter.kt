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
        var day:String?=item.substring(0,2)
        var month:String?=null

        if (item!="All") {
            if (item.substring(3,5)=="01") {
                month="Jan"
                holder.dateval.text=month+" "+day
            }
            if (item.substring(3,5)=="02") {
                month="Feb"
                holder.dateval.text=month+" "+day
            }
            if (item.substring(3,5)=="03") {
                month="Mar"
                holder.dateval.text=month+" "+day
            }
            if (item.substring(3,5)=="04") {
                month="Apr"
                holder.dateval.text=month+" "+day
            }
            if (item.substring(3,5)=="05") {
                month="May"

            }
            if (item.substring(3,5)=="06") {
                month="Jun"

            }
            if (item.substring(3,5)=="07") {
                month="Jul"

            }
            if (item.substring(3,5)=="08") {
                month="Aug"
            }
            if (item.substring(3,5)=="09") {
                month="Sep"
            }
            if (item.substring(3,5)=="10") {
                month="Oct"
            }
            if (item.substring(3,5)=="11") {
                month="Nov"
            }
            if (item.substring(3,5)=="12") {
                month="Dec"
            }
             holder.dateval.text=month+" "+day
        }
        else {
            holder.dateval.text=item
        }
    /*   if (item!="All") {
            holder.dateval.text=item.substring(0,5)
        }
        else{
            holder.dateval.text=item
        }  */


        holder.itemView.setOnClickListener {
            daateeee.value=item

        }
    }

    override fun getItemCount()=data.size
}