package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.MyViewHolder
import com.romp.khel.R
import com.romp.khel.dataclass.Venue
import com.romp.khel.venueviewholderval
import com.romp.khel.vname

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
        holder.venuename.text=item.VenueName.toString()
     //   holder.text2.text=item.Contact.toString()
        holder.venueloc.text=item.Location.toString()
     //   holder.text4.text=item.datev.toString()

        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_booking_to_venueDetails)
            vname =item.VenueName

        }
    }



}