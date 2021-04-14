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
import com.romp.khel.adapters.ChallengeTeamAdapter
import com.romp.khel.challengeteamdetails
import com.romp.khel.dataclass.TournamentDetails
import com.romp.khel.dataclass.team
import com.romp.khel.jointeamdetails
import com.romp.khel.myteamkey

class Challenge_other_team : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("teams")
    lateinit var auth: FirebaseAuth

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

        auth = Firebase.auth
        val currentUser = auth.currentUser

        val adapter=ChallengeTeamAdapter()
        view.findViewById<RecyclerView>(R.id.leaderboards_recycler).adapter=adapter
        view.findViewById<RecyclerView>(R.id.matching_opp_recycler).adapter=adapter
        val progressbar:ProgressBar=view.findViewById(R.id.leaderboards_progressbar)
        progressbar.isIndeterminate
        progressbar.setVisibility(View.VISIBLE)

        var details= mutableListOf<team>()

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                challengeteamdetails= mutableListOf()
                for (postSnapshot in dataSnapshot.children) {
                    var num=0
                    challengeteamdetails.add(postSnapshot.getValue<team>()!!)
                    details.add(postSnapshot.getValue<team>()!!)
                    if (challengeteamdetails.isNotEmpty()) {
                        num= challengeteamdetails.size
                        challengeteamdetails[num-1].key=postSnapshot.key
                    }
                    myteamkey=""
                    if (currentUser!!.email==postSnapshot.child("email1").value || currentUser!!.email==postSnapshot.child("email2").value ||
                        currentUser!!.email==postSnapshot.child("email3").value || currentUser!!.email==postSnapshot.child("email4").value ||
                        currentUser!!.email==postSnapshot.child("email5").value) {
                        myteamkey=postSnapshot.key
                    }

                }
                adapter.data= details
                progressbar.setVisibility(View.INVISIBLE)
            }
        })

    }
}