package com.romp.khel.Fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.romp.khel.*
import com.romp.khel.R
import com.romp.khel.dataclass.TeamChallengeDetails
import com.romp.khel.dataclass.team


class ChallengesAgainstMyTeam : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("potentialchallenges").child(
        myteam_challengeteamdetails[myteam_challengeposition].key.toString())
    var ref: DatabaseReference = database.child("teams")
    var userref : DatabaseReference = database.child("users")
    var accepted:DatabaseReference = database.child("acceptedchallenges")
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_challenges_against_my_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var team1:TextView=view.findViewById(R.id.mtcd_team1)
        var team2:TextView=view.findViewById(R.id.mt_cd_team2)

        var t1_p1:TextView=view.findViewById(R.id.mtcd_t1_player1)
        var t1_p2:TextView=view.findViewById(R.id.mtcd_t1_player2)
        var t1_p3:TextView=view.findViewById(R.id.mtcd_t1_player3)
        var t1_p4:TextView=view.findViewById(R.id.mtcd_t1_player4)
        var t1_p5:TextView=view.findViewById(R.id.mtcd_t1_player5)
        var t2_p1:TextView=view.findViewById(R.id.mtcd_t2_player1)
        var t2_p2:TextView=view.findViewById(R.id.mtcd_t2_player2)
        var t2_p3:TextView=view.findViewById(R.id.mtcd_t2_player3)
        var t2_p4:TextView=view.findViewById(R.id.mtcd_t2_player4)
        var t2_p5:TextView=view.findViewById(R.id.mtcd_t2_player5)

        var t1_p1icon: ImageView =view.findViewById(R.id.mtcd_t1_p1icon)
        var t1_p2icon: ImageView =view.findViewById(R.id.mtcd_t1_p2icon)
        var t1_p3icon: ImageView =view.findViewById(R.id.mtcd_t1_p3icon)
        var t1_p4icon: ImageView =view.findViewById(R.id.mtcd_t1_p4icon)
        var t1_p5icon: ImageView =view.findViewById(R.id.mtcd_t1_p5icon)
        var t2_p1icon: ImageView =view.findViewById(R.id.mtcd_t2_p1icon)
        var t2_p2icon: ImageView =view.findViewById(R.id.mtcd_t2_p2icon)
        var t2_p3icon: ImageView =view.findViewById(R.id.mtcd_t2_p3icon)
        var t2_p4icon: ImageView =view.findViewById(R.id.mtcd_t2_p4icon)
        var t2_p5icon: ImageView =view.findViewById(R.id.mtcd_t2_p5icon)

        var venuename:TextView=view.findViewById(R.id.mtcd_venue)
        var venuloc:TextView=view.findViewById(R.id.mtcd_location)
        var date:TextView=view.findViewById(R.id.mtcd_date)
        var time:TextView=view.findViewById(R.id.mtcd_time)
        var winnerpays:TextView=view.findViewById(R.id.mtcd_winnerpays)
        var phonenum:TextView=view.findViewById(R.id.mtcd_contact)
        var addinfo:TextView=view.findViewById(R.id.mtcd_addinfo)

        var acceptbutton:Button=view.findViewById(R.id.mtcd_acceptbutton)
        var rejectbutton:Button=view.findViewById(R.id.mtcd_rejectbutton)
        var appealbutton:Button=view.findViewById(R.id.mtcd_appealbutton)
        var tea1=team()
        var tea2=team()
        var acceptchallenge=TeamChallengeDetails()

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                team1.text=dataSnapshot.child("team1").value.toString()
                team2.text=dataSnapshot.child("team2").value.toString()
                winnerpays.text=dataSnapshot.child("winnerpays").value.toString()
                time.text=dataSnapshot.child("starttime").value.toString()+"-"+dataSnapshot.child("endtime").value.toString()
                addinfo.text=dataSnapshot.child("addinfo").value.toString()
                phonenum.text=dataSnapshot.child("contact").value.toString()

                venuename.text=dataSnapshot.child("venue").value.toString()
                date.text=dataSnapshot.child("date").value.toString()

               acceptchallenge.team1=dataSnapshot.child("team1").value.toString()
                acceptchallenge.team2=dataSnapshot.child("team2").value.toString()
                acceptchallenge.winnerpays=dataSnapshot.child("winnerpays").value.toString()
                acceptchallenge.starttime=dataSnapshot.child("starttime").value.toString()
                acceptchallenge.endtime=dataSnapshot.child("endtime").value.toString()
                acceptchallenge.addinfo=dataSnapshot.child("addinfo").value.toString()
                acceptchallenge.contact=dataSnapshot.child("contact").value.toString()
                acceptchallenge.date=dataSnapshot.child("date").value.toString()
                acceptchallenge.venue=dataSnapshot.child("venue").value.toString()

                ref.addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
                    }

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (postSnapshot in dataSnapshot.children) {
                            if (postSnapshot.exists()) {
                            if (postSnapshot.child("teamname").value == team2.text) {
                                tea2 = postSnapshot.getValue<team>()!!
                            }
                            if (postSnapshot.child("teamname").value == team1.text) {
                                // tea1.color=postSnapshot.child("color").value.toString()
                                tea1 = postSnapshot.getValue<team>()!!
                            }

                            if (tea1.color == "white") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol)
                            }
                            if (tea2.color == "white") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol)
                            }
                            if (tea1.color == "blue") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_blue)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_blue)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_blue)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_blue)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_blue)
                            }
                            if (tea2.color == "blue") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_blue)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_blue)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_blue)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_blue)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_blue)
                            }
                            if (tea1.color == "lightblue") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_lightblue)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_lightblue)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_lightblue)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_lightblue)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_lightblue)
                            }
                            if (tea2.color == "lightblue") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_lightblue)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_lightblue)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_lightblue)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_lightblue)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_lightblue)
                            }
                            if (tea1.color == "brightgreen") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                            }
                            if (tea2.color == "brightgreen") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                            }
                            if (tea1.color == "brown") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_brown)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_brown)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_brown)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_brown)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_brown)
                            }
                            if (tea2.color == "brown") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_brown)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_brown)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_brown)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_brown)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_brown)
                            }
                            if (tea1.color == "darkgreen") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                            }
                            if (tea2.color == "darkgreen") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                            }
                            if (tea1.color == "grey") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_grey)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_grey)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_grey)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_grey)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_grey)
                            }
                            if (tea2.color == "grey") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_grey)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_grey)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_grey)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_grey)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_grey)
                            }
                            if (tea1.color == "orange") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_orange)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_orange)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_orange)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_orange)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_orange)
                            }
                            if (tea2.color == "orange") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_orange)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_orange)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_orange)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_orange)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_orange)
                            }
                            if (tea1.color == "purple") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_purple)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_purple)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_purple)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_purple)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_purple)
                            }
                            if (tea2.color == "purple") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_purple)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_purple)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_purple)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_purple)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_purple)
                            }
                            if (tea1.color == "red") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_red)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_red)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_red)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_red)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_red)
                            }
                            if (tea2.color == "red") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_red)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_red)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_red)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_red)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_red)
                            }
                            if (tea1.color == "yellow") {
                                t1_p1icon.setImageResource(R.drawable.jerseysmol_yellow)
                                t1_p2icon.setImageResource(R.drawable.jerseysmol_yellow)
                                t1_p3icon.setImageResource(R.drawable.jerseysmol_yellow)
                                t1_p4icon.setImageResource(R.drawable.jerseysmol_yellow)
                                t1_p5icon.setImageResource(R.drawable.jerseysmol_yellow)
                            }
                            if (tea2.color == "yellow") {
                                t2_p1icon.setImageResource(R.drawable.jerseysmol_yellow)
                                t2_p2icon.setImageResource(R.drawable.jerseysmol_yellow)
                                t2_p3icon.setImageResource(R.drawable.jerseysmol_yellow)
                                t2_p4icon.setImageResource(R.drawable.jerseysmol_yellow)
                                t2_p5icon.setImageResource(R.drawable.jerseysmol_yellow)
                            }


                            userref.addValueEventListener(object : ValueEventListener {
                                override fun onCancelled(error: DatabaseError) {
                                    Toast.makeText(
                                        activity,
                                        "onCancelled called",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }

                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    for (postSnapshot in dataSnapshot.children) {
                                        if (postSnapshot.child("email").value == tea1.email1) {
                                            t1_p1.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                        if (postSnapshot.child("email").value == tea1.email2) {
                                            t1_p2.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                        if (postSnapshot.child("email").value == tea1.email3) {
                                            t1_p3.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                        if (postSnapshot.child("email").value == tea1.email4) {
                                            t1_p4.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                        if (postSnapshot.child("email").value == tea1.email5) {
                                            t1_p5.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                        if (postSnapshot.child("email").value == tea2.email1) {
                                            t2_p1.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                        if (postSnapshot.child("email").value == tea2.email2) {
                                            t2_p2.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                        if (postSnapshot.child("email").value == tea2.email3) {
                                            t2_p3.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                        if (postSnapshot.child("email").value == tea2.email4) {
                                            t2_p4.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                        if (postSnapshot.child("email").value == tea2.email5) {
                                            t2_p5.text =
                                                postSnapshot.child("displayname").value.toString()
                                        }
                                    }
                                }
                            })
                        }
                        }
                    }
                })
            }

        })

        val options = arrayOf("Message Via Whatsapp","Call Phone Number")
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Contact Challenger to make changes to the Challenge.")
        builder.setItems(options) { dialog, which ->
            when (which) {
                0 -> {val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("http://api.whatsapp.com/send?phone=+977${phonenum.text}&text=Hello! Your team, ${tea1.teamname} challenged mine, ${tea2.teamname} in Khel. We need to make some changes to play.")
                    startActivity(intent)}
                1 -> {  val intent = Intent(Intent.ACTION_CALL);
                    intent.data = Uri.parse("tel:${phonenum.text}")
                    startActivity(intent)}
            }
        }


        appealbutton.setOnClickListener {
            val dialog = builder.create()
            dialog.show()
        }
        rejectbutton.setOnClickListener {
            val rejectalert = AlertDialog.Builder(context)
            rejectalert.setTitle("Are you Sure?")
            rejectalert.apply {
                setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                        Navigation.findNavController(view).navigate(R.id.action_myTeam_ChallengeDetails_to_myTeam_Challenges)
                        conditionref.removeValue().addOnSuccessListener {
                            Toast.makeText(activity,"Rejection Successful",Toast.LENGTH_SHORT).show()
                        }
                    })
                setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id -> })
            }

        val dialog=rejectalert.create()
            dialog.show()
        }
        acceptbutton.setOnClickListener {
            val acceptalert = AlertDialog.Builder(context)
            acceptalert.setTitle("Are you Sure?")
            acceptalert.setMessage("Forfeiting the match, unless booking is unsuccessful, will result in a loss for your team.")
            acceptalert.apply {
                setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                      accepted.push().setValue(acceptchallenge)
                        Navigation.findNavController(view).navigate(R.id.action_myTeam_ChallengeDetails_to_myTeam_Challenges)
                        conditionref.removeValue().addOnSuccessListener {
                            Toast.makeText(activity,"Challenge Accepted!",Toast.LENGTH_SHORT).show()
                        }
                    })
                setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id -> })
            }

            val dialog=acceptalert.create()
            dialog.show()
        }








    }
}