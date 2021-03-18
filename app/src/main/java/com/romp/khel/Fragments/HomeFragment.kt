package com.romp.khel.Fragments

import android.graphics.Insets.add
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.romp.khel.R
import com.romp.khel.adapters.StealTheDealAdapter
import com.romp.khel.adapters.dateLTPadapter
import com.romp.khel.dataclass.TournamentDetails
import com.romp.khel.adapters.homeadaptertournaments
import com.romp.khel.adapters.newsadapter
import com.romp.khel.dataclass.news


class HomeFragment : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("tournaments")
    var newsref:DatabaseReference = database.child("news")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressbar2:ProgressBar=view.findViewById(R.id.progressBar4)
        progressbar2.isIndeterminate
        progressbar2.setVisibility(View.VISIBLE)

        val newscycle=view.findViewById<RecyclerView>(R.id.newsrecyclerview)
        newscycle.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL ,false)
        val newsadap=newsadapter()
        view.findViewById<RecyclerView>(R.id.newsrecyclerview).adapter=newsadap
        var newsdetails:MutableList<news> = mutableListOf()
      //  newsadap.data= mutableListOf("Futsals Finally Reopen!", "Brand New Futsal Opens")

        newsref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called",Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    newsdetails.add(postSnapshot.getValue<news>()!!)
                }
                newsadap.data=newsdetails
                progressbar2.setVisibility(View.INVISIBLE)
            }

        })



        val buto:Button=view.findViewById(R.id.home_explore_tournament)
        buto.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_tournaments)
        }
        val radapter= homeadaptertournaments()
         view.findViewById<RecyclerView>(R.id.recycle).adapter=radapter


        val progressbar:ProgressBar=view.findViewById(R.id.progressBar)
        progressbar.isIndeterminate
            progressbar.setVisibility(View.VISIBLE);

        var details:MutableList<TournamentDetails> = mutableListOf()


        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called",Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
          //      num = 0
                for (postSnapshot in dataSnapshot.children) {
         //           testdata[num].text = postSnapshot.child("tournamentName").getValue<String>()
                    details.add(postSnapshot.getValue<TournamentDetails>()!!)
          //          num++
                }
              //  Toast.makeText(activity,"size: ${details.size}", Toast.LENGTH_LONG).show()
                radapter.data=details
                progressbar.setVisibility(View.INVISIBLE)

            }

        })



        val stdrecyclerview:RecyclerView=view.findViewById(R.id.stealthedeal_recycleview)
        stdrecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL ,false)

        val stdadapter= StealTheDealAdapter()
        view.findViewById<RecyclerView>(R.id.stealthedeal_recycleview).adapter=stdadapter

        val teststd= mutableListOf<String>("UN Park Futsal", "Boom Futsal", "Good Futsal", "Lood Futsal", "OK Futsal", "NotOK Futsal", "Bad Bad Futsal", "AHAHAH Futsal")
        stdadapter.data=teststd

    }
    }
