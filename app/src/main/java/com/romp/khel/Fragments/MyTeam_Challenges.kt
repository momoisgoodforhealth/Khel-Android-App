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
import com.romp.khel.*
import com.romp.khel.R
import com.romp.khel.adapters.Myteam_AcceptedChallengesAdapter
import com.romp.khel.adapters.Myteam_CFMT_Adapter
import com.romp.khel.adapters.Myteam_ChallengesAdapter
import com.romp.khel.dataclass.TeamChallengeDetails

class MyTeam_Challenges : Fragment() {

    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("potentialchallenges")
    var acceptedref: DatabaseReference = database.child("acceptedchallenges")

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

        val cfmtAdapter=Myteam_CFMT_Adapter()
        view.findViewById<RecyclerView>(R.id.myteamcfmt_recyclerview).adapter=cfmtAdapter

        val acceptedChallengesAdapter=Myteam_AcceptedChallengesAdapter()
        view.findViewById<RecyclerView>(R.id.myteamaccepted_recyclerview).adapter=acceptedChallengesAdapter

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                myteam_challengeteamdetails= mutableListOf()
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.child("team2").value== myteamname) {
                    myteam_challengeteamdetails.add(postSnapshot.getValue<TeamChallengeDetails>()!!)
                    if (myteam_challengeteamdetails.isNotEmpty()) {
                      var  num= myteam_challengeteamdetails.size
                        myteam_challengeteamdetails[num-1].key=postSnapshot.key
                    }
                    }
                }
                adapter.data= myteam_challengeteamdetails
                progressbar.setVisibility(View.INVISIBLE)
            }
        })

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                myteam_cfmtdetails= mutableListOf()
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.child("team1").value== myteamname) {
                        myteam_cfmtdetails.add(postSnapshot.getValue<TeamChallengeDetails>()!!)
                        if (myteam_cfmtdetails.isNotEmpty()) {
                            var  num= myteam_cfmtdetails.size
                            myteam_cfmtdetails[num-1].key=postSnapshot.key
                        }
                    }
                }
                cfmtAdapter.data= myteam_cfmtdetails
                progressbar.setVisibility(View.INVISIBLE)
            }
        })

        acceptedref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                myteam_accepted= mutableListOf()
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.child("team1").value== myteamname) {
                        myteam_accepted.add(postSnapshot.getValue<TeamChallengeDetails>()!!)
                        if (myteam_accepted.isNotEmpty()) {
                            var  num= myteam_accepted.size
                            myteam_accepted[num-1].key=postSnapshot.key
                        }
                    }
                }
                acceptedChallengesAdapter.data= myteam_accepted
                progressbar.setVisibility(View.INVISIBLE)
            }
        })
    }
}