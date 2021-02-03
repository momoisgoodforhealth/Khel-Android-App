package com.romp.khel.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.romp.khel.R
import com.romp.khel.dataclass.Venue
import com.romp.khel.adapters.VenueRecycleViewAdapter


class Booking : Fragment() {

    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("check")
   // var ref : DatabaseReference = database.child("tournaments")
    var venuename1= Venue("Kick Futsal Lalitpur", "", "Dauthulan Road", "9808151351")
    var venuename2= Venue("Shankhamul Futsal", "","Shankhamul Marg",  "01-4782088")
    var venuename3= Venue("Royal Futsal", "","Pushpa Nagar Marga", "01-5244436")
    var venuename4= Venue("Shantinagar Futsal", "","Shantinagar", "9851188182")
    var venuename5= Venue("Prismatic Futsal and Recreation Center", "","Milap Road", "01-5521587")
    var venuename6= Venue("Dhobighat Futsal", "","Dhobighat", "9843129121")
    var venuename7= Venue("Maa Banglamukhi Futsal", "","Dathulan Road, Sankhamul", "01-5260611")


 //   lateinit var timing1:TextView
   // lateinit var timing2:TextView


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

   /*     val time_six=view.findViewById<TextView>(R.id.time_six)
        val time_seven=view.findViewById<TextView>(R.id.time_seven)
        val time_eight=view.findViewById<TextView>(R.id.time_eight)
        val time_nine=view.findViewById<TextView>(R.id.time_nine)
        val time_ten=view.findViewById<TextView>(R.id.time_ten)
        val time_eleven=view.findViewById<TextView>(R.id.time_eleven)
        val time_twelve=view.findViewById<TextView>(R.id.time_twelve)
        val time_thirteen=view.findViewById<TextView>(R.id.time_thirteen)
        val time_fourteen=view.findViewById<TextView>(R.id.time_fourteen)
        val time_fifteen=view.findViewById<TextView>(R.id.time_fifteen)
        val time_sixteen=view.findViewById<TextView>(R.id.time_sixteen)
        val time_seventeen=view.findViewById<TextView>(R.id.time_seventeen)
        val time_eightteen=view.findViewById<TextView>(R.id.time_eighteen)  */

        val vadapter= VenueRecycleViewAdapter()
        view.findViewById<RecyclerView>(R.id.venue_recycle).adapter=vadapter


        var venuenames:MutableList<Venue> = mutableListOf(venuename1,venuename2,venuename3,venuename4,venuename5,venuename6,venuename7)
        vadapter.data=venuenames


  /* conditionref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.key=="check1" && postSnapshot.getValue().toString()=="1") { time_six.setTextColor(Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check1" && postSnapshot.getValue().toString()=="0") { time_six.setTextColor(Color.parseColor("#EC2F2F")) }
                    if (postSnapshot.key=="check2" && postSnapshot.getValue().toString()=="1") { time_seven.setTextColor(Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check2" && postSnapshot.getValue().toString()=="0") { time_seven.setTextColor(Color.parseColor("#EC2F2F")) }
                    if (postSnapshot.key=="check3" && postSnapshot.getValue().toString()=="1") { time_eight.setTextColor(Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check3" && postSnapshot.getValue().toString()=="0") { time_eight.setTextColor(Color.parseColor("#EC2F2F")) }
                    if (postSnapshot.key=="check4" && postSnapshot.getValue().toString()=="1") { time_nine.setTextColor(Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check4" && postSnapshot.getValue().toString()=="0") { time_nine.setTextColor(Color.parseColor("#EC2F2F")) }
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })  */


    }
}