package com.romp.khel.Fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.romp.khel.R
import com.romp.khel.adapters.LookingtoPlayAdapter
import com.romp.khel.adapters.adapter
import com.romp.khel.adapters.dateLTPadapter
import com.romp.khel.daateeee
import com.romp.khel.dataclass.LookingtoPlayRoom
import com.romp.khel.dataclass.TournamentDetails


class LookingtoPlay : Fragment() {
    lateinit var buto:Button
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("lookingtoplay")
    var date: DatabaseReference = database.child("lookingtoplay")

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lookingto_play, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radapter= LookingtoPlayAdapter()
        view.findViewById<RecyclerView>(R.id.ltp_recycleview).adapter=radapter
        val progressbar: ProgressBar =view.findViewById(R.id.ltp_progressbar)
        progressbar.isIndeterminate
        progressbar.setVisibility(View.VISIBLE)

        var details:MutableList<LookingtoPlayRoom> = mutableListOf()

        fun execute() {
            conditionref.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(activity, "onCancelled called", Toast.LENGTH_LONG).show()
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (postSnapshot in dataSnapshot.children) {
                        if (daateeee.value == "All" || daateeee.value == null) {
                            details.add(postSnapshot.getValue<LookingtoPlayRoom>()!!)
                        } else {
                            if (daateeee.value == postSnapshot.child("date").getValue<String>().toString()) {
                                details.add(postSnapshot.getValue<LookingtoPlayRoom>()!!)
                            }
                        }
                    }
                    radapter.data = details
                    progressbar.setVisibility(View.INVISIBLE)

                }

            })
        }
        execute()

        val daterecycleview:RecyclerView=view.findViewById(R.id.date_recycleview)
        daterecycleview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL ,false)


        val dateadapter=dateLTPadapter()
        view.findViewById<RecyclerView>(R.id.date_recycleview).adapter=dateadapter

        daateeee.observeForever {
            details.clear()
            dateadapter.notifyDataSetChanged()
            execute()
        }

        val testdate= mutableListOf<String>("All")

        date.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                        testdate.add(postSnapshot.child("date").getValue<String>().toString())
                }
                dateadapter.data=testdate

            }

        })


        buto=view.findViewById(R.id.ltp_add_button)
        buto.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_lookingtoPlay_to_formFragment_LTP)
        }

    }
}