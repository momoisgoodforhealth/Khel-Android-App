package com.romp.khel.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.romp.khel.R
import com.romp.khel.dataclass.Venue
import com.romp.khel.adapters.VenueRecycleViewAdapter


class Booking : Fragment() {

    var database = FirebaseDatabase.getInstance().getReference()

    var venuename1= Venue("Kick Futsal Lalitpur", "", "Dauthulan Road", "9808151351")
    var venuename2= Venue("Shankhamul Futsal", "","Shankhamul Marg",  "01-4782088")
    var venuename3= Venue("Royal Futsal", "","Pushpa Nagar Marga", "01-5244436")
    var venuename4= Venue("Shantinagar Futsal", "","Shantinagar", "9851188182")
    var venuename5= Venue("Prismatic Futsal and Recreation Center", "","Milap Road", "01-5521587")
    var venuename6= Venue("Dhobighat Futsal", "","Dhobighat", "9843129121")
    var venuename7= Venue("Maa Banglamukhi Futsal", "","Dathulan Road, Sankhamul", "01-5260611")

    lateinit var alertbutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_booking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
  //      timing1=view.findViewById(R.id.time1)
  //      timing2=view.findViewById(R.id.time2)
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Sort By District")

        alertbutton=view.findViewById(R.id.alert)

        val vadapter= VenueRecycleViewAdapter()
        view.findViewById<RecyclerView>(R.id.venue_recycle).adapter=vadapter


        var venuenames:MutableList<Venue> = mutableListOf(venuename1,venuename2,venuename3,venuename4,venuename5,venuename6,venuename7)
        vadapter.data=venuenames


        val loc = arrayOf("Kathmandu","Pokhara", "Lalitpur","Bhaktapur", "All")
        builder.setItems(loc) { dialog, which ->
            when (which) {
                0 -> {venuenames= mutableListOf(venuename3, venuename4,venuename7) ;   vadapter.data=venuenames}
                1 -> { venuenames= mutableListOf() ;   vadapter.data=venuenames }
                2 -> {venuenames= mutableListOf(venuename1,venuename2,venuename5, venuename6) ;   vadapter.data=venuenames}
                3 -> { venuenames= mutableListOf() ;   vadapter.data=venuenames}
                4 -> {venuenames=mutableListOf(venuename1,venuename2,venuename3,venuename4,venuename5,venuename6,venuename7) ;  vadapter.data=venuenames}
            }
        }

        alertbutton.setOnClickListener {
            val dialog = builder.create()
            dialog.show()
        }


    }
}