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
import com.romp.khel.adapters.ChallengeTeamAdapter
import com.romp.khel.dataclass.TournamentDetails

class Challenge_other_team : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("teams")

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_challenge_other_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=ChallengeTeamAdapter()
        view.findViewById<RecyclerView>(R.id.leaderboards_recycler).adapter=adapter
        view.findViewById<RecyclerView>(R.id.matching_opp_recycler).adapter=adapter
        val progressbar:ProgressBar=view.findViewById(R.id.leaderboards_progressbar)
        progressbar.isIndeterminate
        progressbar.setVisibility(View.VISIBLE)

        var details= mutableListOf<String>()

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    details.add(postSnapshot.child("teamname").value.toString())
                }
                adapter.data=details
                progressbar.setVisibility(View.INVISIBLE)

            }

        })

    }
}