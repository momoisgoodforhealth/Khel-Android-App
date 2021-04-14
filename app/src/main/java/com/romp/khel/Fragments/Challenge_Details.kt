package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.key== myteamkey) {
                        team1name.text=postSnapshot.child("teamname").value.toString()
                    }
                    if (postSnapshot.key == challengeteamdetails[challengeposition].key) {
                        team2name.text=postSnapshot.child("teamname").value.toString()
                  //  team2name.text= challengeteamdetails.size.toString()
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