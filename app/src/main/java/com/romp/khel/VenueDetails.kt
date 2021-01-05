package com.romp.khel

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.database.*

class VenueDetails : Fragment() {

    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("check")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { return inflater.inflate(R.layout.fragment_venue_details, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val venue_name=view.findViewById<TextView>(R.id.venue_name)
        venue_name.text= vname
     val time_six=view.findViewById<TextView>(R.id.time_six)
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
        val time_eightteen=view.findViewById<TextView>(R.id.time_eighteen)



        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.key=="check1" && postSnapshot.getValue().toString()=="1") { time_six.setTextColor(
                        Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check1" && postSnapshot.getValue().toString()=="0") { time_six.setTextColor(
                        Color.parseColor("#EC2F2F")) }
                    if (postSnapshot.key=="check2" && postSnapshot.getValue().toString()=="1") { time_seven.setTextColor(
                        Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check2" && postSnapshot.getValue().toString()=="0") { time_seven.setTextColor(
                        Color.parseColor("#EC2F2F")) }
                    if (postSnapshot.key=="check3" && postSnapshot.getValue().toString()=="1") { time_eight.setTextColor(
                        Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check3" && postSnapshot.getValue().toString()=="0") { time_eight.setTextColor(
                        Color.parseColor("#EC2F2F")) }
                    if (postSnapshot.key=="check4" && postSnapshot.getValue().toString()=="1") { time_nine.setTextColor(
                        Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check4" && postSnapshot.getValue().toString()=="0") { time_nine.setTextColor(
                        Color.parseColor("#EC2F2F")) }
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}