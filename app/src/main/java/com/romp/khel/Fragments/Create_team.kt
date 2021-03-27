package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.romp.khel.R
import com.romp.khel.dataclass.team


class Create_team : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_team, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser

        var teamname:EditText=view.findViewById(R.id.ct_editteamname)
        var email1=currentUser!!.email
        var email2:EditText=view.findViewById(R.id.ct_email1)
        var email3:EditText=view.findViewById(R.id.ct_email2)
        var email4:EditText=view.findViewById(R.id.ct_email3)
        var email5:EditText=view.findViewById(R.id.ct_email4)
        var submit:Button=view.findViewById(R.id.createteam_submitbutton)

        fun createteam(tn:String,e1:String,e2:String,e3:String,e4:String,e5:String){
            var teamm=team(tn,e1,e2,e3,e4,e5)
            database.child("teams").push().setValue(teamm)
                .addOnSuccessListener {
                Navigation.findNavController(view).navigate(R.id.action_create_team_to_tournamentSuccess)
            }
                .addOnFailureListener {
                    Toast.makeText(activity,"ERROR: $it", Toast.LENGTH_LONG).show()
                }
        }

        submit.setOnClickListener {
            if (teamname.text.toString().trim().isBlank() || email1.toString().trim().isBlank() || email2.text.toString().trim().isBlank()
                || email3.text.toString().trim().isBlank() || email4.text.toString().trim().isBlank() || email5.text.toString().trim().isBlank()) {
                Toast.makeText(activity, "Complete All The Fields", Toast.LENGTH_LONG).show()
            }
            else {
                createteam(teamname.text.toString(),email1.toString(),email2.text.toString(),email3.text.toString(),email4.text.toString(), email5.text.toString())
            }

        }


    }
}