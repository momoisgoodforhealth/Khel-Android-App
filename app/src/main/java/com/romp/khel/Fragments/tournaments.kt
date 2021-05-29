package com.romp.khel.Fragments

import com.romp.khel.adapters.adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.romp.khel.R
import com.romp.khel.dataclass.TournamentDetails


class tournaments : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("tournaments")

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? { return inflater.inflate(R.layout.fragment_tournaments, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val radapter= adapter()
        view.findViewById<RecyclerView>(R.id.recycle).adapter=radapter


        val progressbar: ProgressBar =view.findViewById(R.id.progressBar)
        progressbar.isIndeterminate
        progressbar.setVisibility(View.VISIBLE)

        val button: Button = view.findViewById(R.id.add_tour_button)
        button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_tournaments_to_formFragment)
        }

        var details:MutableList<TournamentDetails> = mutableListOf()

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    details.add(postSnapshot.getValue<TournamentDetails>()!!)
                }
                radapter.data=details
                progressbar.setVisibility(View.INVISIBLE)
            }

        })

    }
}
