package com.romp.khel.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.romp.khel.R
import com.romp.khel.adapters.MyCreatedLTPadapter
import com.romp.khel.dataclass.LookingtoPlayRoom
import com.romp.khel.keyy


class Myteam : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("lookingtoplay")
    lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_myteam, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        val currentUser = auth.currentUser

        val radapter= MyCreatedLTPadapter()
        view.findViewById<RecyclerView>(R.id.mycreatedLTP_recycleview).adapter=radapter

        val progressbar: ProgressBar =view.findViewById(R.id.mycreatedLTP_progressbar)
        progressbar.isIndeterminate
        progressbar.setVisibility(View.VISIBLE)

        var details:MutableList<LookingtoPlayRoom> = mutableListOf()

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (currentUser?.uid==postSnapshot.child("uid").value) {
                        details.add(postSnapshot.getValue<LookingtoPlayRoom>()!!)
                        keyy=postSnapshot.key
                    }

                }
                radapter.data=details
                progressbar.setVisibility(View.INVISIBLE)
            }

        })
    }
}
