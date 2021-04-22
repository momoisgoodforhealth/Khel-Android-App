package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.romp.khel.R
import com.romp.khel.adapters.Myteam_ChallengesAdapter
import com.romp.khel.dataclass.TeamChallengeDetails

class MyTeam_Challenges : Fragment() {

    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("potentialchallenges")

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_myteam_challenges, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressbar:ProgressBar=view.findViewById(R.id.progressBarr2)
        progressbar.isIndeterminate
        progressbar.setVisibility(View.VISIBLE)

        val adapter=Myteam_ChallengesAdapter()
        view.findViewById<RecyclerView>(R.id.myteamchallenges_recyclerview).adapter=adapter

        var details= mutableListOf<TeamChallengeDetails>()
        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
               //     if (postSnapshot.child("team2")==)
                    details.add(postSnapshot.getValue<TeamChallengeDetails>()!!)
                }
                adapter.data=details
                progressbar.setVisibility(View.INVISIBLE)
            }
        })
    }
}