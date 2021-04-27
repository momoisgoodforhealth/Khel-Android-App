package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.romp.khel.R
import com.romp.khel.jointeamdetails
import com.romp.khel.jtdposition

class Join_Team_Detalis : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("teams").child(jointeamdetails[jtdposition].key.toString())
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_join_team_detalis, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var jtd:TextView=view.findViewById(R.id.jtd_teamname)
        var email:String?=null
        auth = Firebase.auth
        val currentUser = auth.currentUser
        var jtd_djb:Button=view.findViewById(R.id.jtd_dontjoinbutton)
        var jtd_jb:Button=view.findViewById(R.id.jtd_joinbutton)
        conditionref.addValueEventListener(object : ValueEventListener {



            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                email=null
                if (dataSnapshot.exists()) {
                    jtd.text= dataSnapshot.child("teamname").value.toString()
                    if (dataSnapshot.child("iemail2").value.toString()==currentUser!!.email) {
                        email="iemail2"
                    }
                    if (dataSnapshot.child("iemail3").value.toString()==currentUser!!.email) {
                        email="iemail3"
                    }
                    if (dataSnapshot.child("iemail4").value.toString()==currentUser!!.email) {
                        email="iemail4"
                    }
                    if (dataSnapshot.child("iemail5").value.toString()==currentUser!!.email) {
                        email="iemail5"
                    }
                }
            }

        })

        jtd_djb.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_join_Team_Detalis_to_join_Team)
            conditionref.child(email.toString()).setValue("")
        }

        jtd_jb.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_join_Team_Detalis_to_myteam)
            if (email=="iemail2"){
                conditionref.child("email2").setValue(currentUser!!.email)
                conditionref.child(email.toString()).setValue("")
            }
            if (email=="iemail3"){
                conditionref.child("email3").setValue(currentUser!!.email)
                conditionref.child(email.toString()).setValue("")
            }
            if (email=="iemail4"){
                conditionref.child("email4").setValue(currentUser!!.email)
                conditionref.child(email.toString()).setValue("")
            }
            if (email=="iemail5"){
                conditionref.child("email5").setValue(currentUser!!.email)
                conditionref.child(email.toString()).setValue("")
            }
        }

    }
}