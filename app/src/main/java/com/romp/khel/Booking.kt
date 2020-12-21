package com.romp.khel

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.database.*


class Booking : Fragment() {

    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("check")

    lateinit var timing1:TextView
    lateinit var timing2:TextView

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
        timing1=view.findViewById(R.id.time1)
        timing2=view.findViewById(R.id.time2)

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.key=="check1" && postSnapshot.getValue().toString()=="1") { timing1.setTextColor(Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check1" && postSnapshot.getValue().toString()=="0") { timing1.setTextColor(Color.parseColor("#EC2F2F")) }
                    if (postSnapshot.key=="check2" && postSnapshot.getValue().toString()=="1") { timing2.setTextColor(Color.parseColor("#46EC2F")) }
                    if (postSnapshot.key=="check2" && postSnapshot.getValue().toString()=="0") { timing2.setTextColor(Color.parseColor("#EC2F2F")) }
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}