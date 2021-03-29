package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.romp.khel.R
import com.romp.khel.adapters.TeamInvitationAdapter

class Join_Team : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    lateinit var auth: FirebaseAuth
    var conditionref: DatabaseReference = database.child("teams")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_join_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser

        var adapter= TeamInvitationAdapter()
        view.findViewById<RecyclerView>(R.id.jointeam_recyclerview).adapter=adapter

        var details= mutableListOf<String>()

        val progressbar: ProgressBar =view.findViewById(R.id.jointeam_progressbar)
        progressbar.isIndeterminate
        progressbar.setVisibility(View.VISIBLE)
        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (currentUser?.email==postSnapshot.child("iemail2").value || currentUser?.email==postSnapshot.child("iemail3").value
                        || currentUser?.email==postSnapshot.child("iemail4").value || currentUser?.email==postSnapshot.child("iemail5").value) {
                        details.add(postSnapshot.child("teamname").value.toString())
                    }

                }
                adapter.data=details
                progressbar.setVisibility(View.INVISIBLE)
            }

        })
    }
}