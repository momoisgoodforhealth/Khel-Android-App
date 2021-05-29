package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.romp.khel.*
import com.romp.khel.dataclass.Venue

class VenueRecycleViewAdapter: RecyclerView.Adapter<venueviewholderval>()  {
    var data= listOf<Venue>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): venueviewholderval {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.venue_cardview, parent, false) as CardView
        return venueviewholderval(view)
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: venueviewholderval, position: Int) {
        val item=data[position]
        holder.venuename.text=item.futsalname.toString()
        holder.venueloc.text=item.location.toString()
        Glide.with(holder.itemView).load(item.picurl).centerCrop().into(holder.venueimg)

        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_booking_to_venueDetails)
            vname =item.futsalname
            venuekey=item.key
        }
    }



}