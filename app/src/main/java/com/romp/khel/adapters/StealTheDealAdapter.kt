package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.romp.khel.R
import com.romp.khel.daateeee
import com.romp.khel.dataclass.DealSteal
import com.romp.khel.dataclass.TournamentDetails
import com.romp.khel.datecardview
import com.romp.khel.stealthedeal
import java.util.*

class StealTheDealAdapter: RecyclerView.Adapter<stealthedeal>()  {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("futsal")

    var data= listOf<DealSteal>()
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
      //  holder.venuename.text=item.name
        var time:String?=""
        var date:String?=""
        var url:String?=""
        if (item.time=="price1") {time="6am"}
        else if (item.time=="price2") {time="7am"}
        else if (item.time=="price3") {time="8am"}
        else if (item.time=="price4") {time="9am"}
        else if (item.time=="price5") {time="10am"}
        else if (item.time=="price6") {time="11am"}
        else if (item.time=="price7") {time="12pm"}
        else if (item.time=="price8") {time="1pm"}
        else if (item.time=="price9") {time="2pm"}
        else if (item.time=="price10") {time="3pm"}
        else if (item.time=="price11") {time="4pm"}
        else if (item.time=="price12") {time="5pm"}
        else if (item.time=="price13") {time="6pm"}

        //  val today = Calendar.getInstance()
        /* date= today.get(Calendar.YEAR).toString()+today.get(Calendar.MONTH).toString()+today.get(Calendar.DAY_OF_MONTH).toString()
          datepiku.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
              today.get(Calendar.DAY_OF_MONTH)) { v, i, i2, i3 ->
              var ii3=i3.toString()
              var ie2=i2+1
              var ii2=ie2.toString()
              if (i3<10) { ii3="0"+i3 }
              if (ie2<10) { ii2="0"+ie2}
              date.text="$ii3/$ii2/$i"
          }  */

        if (item.date=="1") {
            date="Today"
        }
        else if (item.date=="2") {
            date="Tommorrow"
        }
        else if (item.date=="3") {
            date="Day After Tommorrow"
        }
        else if (item.date=="4") {
            date="3 Days from Today"
        }
        else if (item.date=="5") {
            date="4 Days from Today"
        }
        else if (item.date=="6") {
            date="5 Days from Today"
        }
        else if (item.date=="7") {
            date="5 Days from Today"
        }
        else if (item.date=="8") {
            date="6 Days from Today"
        }
        holder.datetime.text=time+"@"+date
        holder.price.text="Rs"+item.price

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
             //   Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                   if (postSnapshot.key==item.name) {
                       holder.venuename.text=postSnapshot.child("futsalname").value.toString()
                       url=postSnapshot.child("picurl").value.toString()
                       Glide.with(holder.itemView).load(url).centerCrop().into(holder.image)
                   }
                }

            }

        })

        holder.itemView.setOnClickListener {
            daateeee.value=item.name
        }

    }

    override fun getItemCount()=data.size
}