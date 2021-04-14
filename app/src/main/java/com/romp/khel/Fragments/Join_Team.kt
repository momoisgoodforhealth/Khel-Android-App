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
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.romp.khel.R
import com.romp.khel.adapters.TeamInvitationAdapter
import com.romp.khel.dataclass.jteam
import com.romp.khel.dataclass.team
import com.romp.khel.jointeamdetails

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
    ): View? {.3
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_join_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser

        var adapter= TeamInvitationAdapter()
        view.findViewById<RecyclerView>(R.id.jointeam_recyclerview).adapter=adapter

      //  var details= mutableListOf<jteam>()

        val progressbar: ProgressBar =view.findViewById(R.id.jointeam_progressbar)
        progressbar.isIndeterminate
        progressbar.setVisibility(View.VISIBLE)
        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                jointeamdetails= mutableListOf()
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.exists() && currentUser?.email==postSnapshot.child("iemail2").value || currentUser?.email==postSnapshot.child("iemail3").value
                        || currentUser?.email==postSnapshot.child("iemail4").value || currentUser?.email==postSnapshot.child("iemail5").value) {
                            var num=0
                        jointeamdetails.add(postSnapshot.getValue<jteam>()!!)
                        if (jointeamdetails.isNotEmpty()){
                            num=jointeamdetails.size
                            jointeamdetails[num-1].key=postSnapshot.key
                        }
                    }

                }
                adapter.data=jointeamdetails
                progressbar.setVisibility(View.INVISIBLE)
            }

        })
    }
}