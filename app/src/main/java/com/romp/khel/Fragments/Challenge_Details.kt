package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.romp.khel.*
import com.romp.khel.R
import com.romp.khel.dataclass.team

class Challenge_Details : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("teams")
    var userref: DatabaseReference = database.child("users")

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_challenge_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val winnerpays :TextView=view.findViewById(R.id.winnerpays)
        val seekBar = view.findViewById<SeekBar>(R.id.cd_price_seekbar)
        var team1name:TextView=view.findViewById(R.id.cd_team1)
        var team2name:TextView=view.findViewById(R.id.cd_team2)
        var team1=team()
        var team2=team()

        var t1_p1:TextView=view.findViewById(R.id.cd_t1_player1)
        var t1_p2:TextView=view.findViewById(R.id.cd_t1_player2)
        var t1_p3:TextView=view.findViewById(R.id.cd_t1_player3)
        var t1_p4:TextView=view.findViewById(R.id.cd_t1_player4)
        var t1_p5:TextView=view.findViewById(R.id.cd_t1_player5)
        var t2_p1:TextView=view.findViewById(R.id.cd_t2_player1)
        var t2_p2:TextView=view.findViewById(R.id.cd_t2_player2)
        var t2_p3:TextView=view.findViewById(R.id.cd_t2_player3)
        var t2_p4:TextView=view.findViewById(R.id.cd_t2_player4)
        var t2_p5:TextView=view.findViewById(R.id.cd_t2_player5)

        var t1_p1icon:ImageView=view.findViewById(R.id.cd_t1_p1icon)
        var t1_p2icon:ImageView=view.findViewById(R.id.cd_t1_p2icon)
        var t1_p3icon:ImageView=view.findViewById(R.id.cd_t1_p3icon)
        var t1_p4icon:ImageView=view.findViewById(R.id.cd_t1_p4icon)
        var t1_p5icon:ImageView=view.findViewById(R.id.cd_t1_p5icon)
        var t2_p1icon:ImageView=view.findViewById(R.id.cd_t2_p1icon)
        var t2_p2icon:ImageView=view.findViewById(R.id.cd_t2_p2icon)
        var t2_p3icon:ImageView=view.findViewById(R.id.cd_t2_p3icon)
        var t2_p4icon:ImageView=view.findViewById(R.id.cd_t2_p4icon)
        var t2_p5icon:ImageView=view.findViewById(R.id.cd_t2_p5icon)



        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.key== myteamkey) {
                        team1.color=postSnapshot.child("color").value.toString()
                        team1name.text=postSnapshot.child("teamname").value.toString()
                        team1.email1=postSnapshot.child("email1").value.toString()
                        team1.email2=postSnapshot.child("email2").value.toString()
                        team1.email3=postSnapshot.child("email3").value.toString()
                        team1.email4=postSnapshot.child("email4").value.toString()
                        team1.email5=postSnapshot.child("email5").value.toString()



                    }
                    if (postSnapshot.key == challengeteamdetails[challengeposition].key) {
                        team2.color=postSnapshot.child("color").value.toString()
                        team2name.text=postSnapshot.child("teamname").value.toString()
                        team2.email1=postSnapshot.child("email1").value.toString()
                        team2.email2=postSnapshot.child("email2").value.toString()
                        team2.email3=postSnapshot.child("email3").value.toString()
                        team2.email4=postSnapshot.child("email4").value.toString()
                        team2.email5=postSnapshot.child("email5").value.toString()
                    }
                }

                if (team1.color=="white") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol)
                }
                if (team2.color=="white") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol)
                }
                if (team1.color=="blue") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_blue)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_blue)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_blue)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_blue)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_blue)
                }

                if (team2.color=="blue") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_blue)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_blue)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_blue)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_blue)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_blue)
                }

                if (team1.color=="lightblue") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_lightblue)
                }
                if (team2.color=="lightblue") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_lightblue)
                }

                if (team1.color=="brightgreen") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                }
                if (team2.color=="brightgreen") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                }
                if (team1.color=="brown") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_brown)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_brown)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_brown)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_brown)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_brown)
                }
                if (team2.color=="brown") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_brown)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_brown)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_brown)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_brown)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_brown)
                }
                if (team1.color=="darkgreen") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                }
                if (team2.color=="darkgreen") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                }
                if (team1.color=="grey") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_grey)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_grey)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_grey)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_grey)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_grey)
                }
                if (team2.color=="grey") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_grey)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_grey)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_grey)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_grey)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_grey)
                }
                if (team1.color=="orange") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_orange)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_orange)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_orange)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_orange)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_orange)
                }
                if (team2.color=="orange") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_orange)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_orange)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_orange)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_orange)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_orange)
                }
                if (team1.color=="purple") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_purple)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_purple)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_purple)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_purple)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_purple)
                }
                if (team2.color=="purple") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_purple)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_purple)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_purple)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_purple)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_purple)
                }
                if (team1.color=="red") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_red)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_red)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_red)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_red)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_red)
                }
                if (team2.color=="red") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_red)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_red)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_red)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_red)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_red)
                }
                if (team1.color=="yellow") {
                    t1_p1icon.setImageResource(R.drawable.jerseysmol_yellow)
                    t1_p2icon.setImageResource(R.drawable.jerseysmol_yellow)
                    t1_p3icon.setImageResource(R.drawable.jerseysmol_yellow)
                    t1_p4icon.setImageResource(R.drawable.jerseysmol_yellow)
                    t1_p5icon.setImageResource(R.drawable.jerseysmol_yellow)
                }
                if (team2.color=="yellow") {
                    t2_p1icon.setImageResource(R.drawable.jerseysmol_yellow)
                    t2_p2icon.setImageResource(R.drawable.jerseysmol_yellow)
                    t2_p3icon.setImageResource(R.drawable.jerseysmol_yellow)
                    t2_p4icon.setImageResource(R.drawable.jerseysmol_yellow)
                    t2_p5icon.setImageResource(R.drawable.jerseysmol_yellow)
                }
            }

        })

        userref.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.child("email").value==team1.email1) {
                        t1_p1.text=postSnapshot.child("displayname").value.toString()
                    }
                    if (postSnapshot.child("email").value==team1.email2) {
                        t1_p2.text=postSnapshot.child("displayname").value.toString()
                    }
                    if (postSnapshot.child("email").value==team1.email3) {
                        t1_p3.text=postSnapshot.child("displayname").value.toString()
                    }
                    if (postSnapshot.child("email").value==team1.email4) {
                        t1_p4.text=postSnapshot.child("displayname").value.toString()
                    }
                    if (postSnapshot.child("email").value==team1.email5) {
                        t1_p5.text=postSnapshot.child("displayname").value.toString()
                    }
                    if (postSnapshot.child("email").value==team2.email1) {
                        t2_p1.text=postSnapshot.child("displayname").value.toString()
                    }
                    if (postSnapshot.child("email").value==team2.email2) {
                        t2_p2.text=postSnapshot.child("displayname").value.toString()
                    }
                    if (postSnapshot.child("email").value==team2.email3) {
                        t2_p3.text=postSnapshot.child("displayname").value.toString()
                    }
                    if (postSnapshot.child("email").value==team2.email4) {
                        t2_p4.text=postSnapshot.child("displayname").value.toString()
                    }
                    if (postSnapshot.child("email").value==team2.email5) {
                        t2_p5.text=postSnapshot.child("displayname").value.toString()
                    }
                }
            }

        })
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }
 
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            //    Toast.makeText(activity, "Current value is " + seekBar.progress, Toast.LENGTH_SHORT).show()
                winnerpays.text="${seekBar.progress}0%"
            }
        })

    }
}