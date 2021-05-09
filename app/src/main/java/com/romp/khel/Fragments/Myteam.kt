    package com.romp.khel.Fragments


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.romp.khel.*
import com.romp.khel.R
import com.romp.khel.adapters.MyCreatedLTPadapter
import com.romp.khel.adapters.PendingInvitationAdapter
import com.romp.khel.dataclass.LookingtoPlayRoom
import com.romp.khel.dataclass.team


    class Myteam : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("lookingtoplay")
    var ref: DatabaseReference = database.child("teams")
    var userref: DatabaseReference = database.child("users")
    lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_myteam, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        val currentUser = auth.currentUser
        if (currentUser==null) { Navigation.findNavController(view).navigate(R.id.action_myteam_to_signUp_Login_Fragment) }

        var player1: TextView =view.findViewById(R.id.p1)
        var player2: TextView =view.findViewById(R.id.p2)
        var player3: TextView =view.findViewById(R.id.p3)
        var player4: TextView =view.findViewById(R.id.p4)
        var player5: TextView =view.findViewById(R.id.p5)
        var playericon1: TextView =view.findViewById(R.id.player1)
        var playericon2: TextView =view.findViewById(R.id.player2)
        var playericon3: TextView =view.findViewById(R.id.player3)
        var playericon4: TextView =view.findViewById(R.id.player4)
        var playericon5: TextView =view.findViewById(R.id.player5)
     //   var invite2:TextView=view.findViewById(R.id.invitation_email2)
     //   var invite3:TextView=view.findViewById(R.id.invitation_email3)
      //  var invite4:TextView=view.findViewById(R.id.invitation_email4)
      //  var invite5:TextView=view.findViewById(R.id.invitation_email5)
        var editteambutton:Button=view.findViewById(R.id.teamnameedit)
        var pl1icon:ImageView=view.findViewById(R.id.playericon1)
        var pl2icon:ImageView=view.findViewById(R.id.playericon2)
        var pl3icon:ImageView=view.findViewById(R.id.playericon3)
        var pl4icon:ImageView=view.findViewById(R.id.playericon4)
        var pl5icon:ImageView=view.findViewById(R.id.playericon5)
        var challengesbutton:Button=view.findViewById(R.id.challenges_button)



        var teamname:TextView=view.findViewById(R.id.teamname)
        var myteam=team()
        var flag=false
        var pendingemail_list= mutableListOf<String?>()

        var pendingrecycler=PendingInvitationAdapter()
        view.findViewById<RecyclerView>(R.id.pendinginvitation_recyclerview).adapter=pendingrecycler

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.exists()) {
                        pendingemail_list = mutableListOf()
                    if (currentUser?.email == postSnapshot.child("email1").value) {
                        //    player1.text=currentUser!!.displayName
                        //   teamname.text=postSnapshot.child("teamname").value.toString()
                        //    playericon1.text=player1.text
                        myteam.key = postSnapshot.key
                        invitationkey = postSnapshot.key
                        myteam.teamname = postSnapshot.child("teamname").value.toString()
                        myteam.email1 = postSnapshot.child("email1").value.toString()
                        myteam.email2 = postSnapshot.child("email2").value.toString()
                        myteam.email3 = postSnapshot.child("email3").value.toString()
                        myteam.email4 = postSnapshot.child("email4").value.toString()
                        myteam.email5 = postSnapshot.child("email5").value.toString()
                        myteam.iemail2 = postSnapshot.child("iemail2").value.toString()
                        myteam.iemail3 = postSnapshot.child("iemail3").value.toString()
                        myteam.iemail4 = postSnapshot.child("iemail4").value.toString()
                        myteam.iemail5 = postSnapshot.child("iemail5").value.toString()
                        myteam.color = postSnapshot.child("color").value.toString()
                        if (myteam.iemail2!!.isNotEmpty() || myteam.iemail2!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail2)
                        }
                        if (myteam.iemail3!!.isNotEmpty() || myteam.iemail3!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail3)
                        }
                        if (myteam.iemail4!!.isNotEmpty() || myteam.iemail4!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail4)
                        }
                        if (myteam.iemail5!!.isNotEmpty() || myteam.iemail5!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail5)
                        }
                        //  pendingemail_list= mutableListOf(myteam.iemail2,myteam.iemail3,myteam.iemail4,myteam.iemail5)
                        pendingrecycler.data = pendingemail_list
                   //     invite2.text = myteam.iemail2
                   //     invite3.text = myteam.iemail3
                    //    invite4.text = myteam.iemail4
                    //   invite5.text = myteam.iemail5
                    } else if (currentUser?.email == postSnapshot.child("email2").value) {
                        myteam.key = postSnapshot.key
                        invitationkey = postSnapshot.key
                        myteam.teamname = postSnapshot.child("teamname").value.toString()
                        myteam.email1 = postSnapshot.child("email1").value.toString()
                        myteam.email2 = postSnapshot.child("email2").value.toString()
                        myteam.email3 = postSnapshot.child("email3").value.toString()
                        myteam.email4 = postSnapshot.child("email4").value.toString()
                        myteam.email5 = postSnapshot.child("email5").value.toString()
                        myteam.iemail2 = postSnapshot.child("iemail2").value.toString()
                        myteam.iemail3 = postSnapshot.child("iemail3").value.toString()
                        myteam.iemail4 = postSnapshot.child("iemail4").value.toString()
                        myteam.iemail5 = postSnapshot.child("iemail5").value.toString()
                        myteam.color = postSnapshot.child("color").value.toString()
                        if (myteam.iemail2!!.isNotEmpty() || myteam.iemail2!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail2)
                        }
                        if (myteam.iemail3!!.isNotEmpty() || myteam.iemail3!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail3)
                        }
                        if (myteam.iemail4!!.isNotEmpty() || myteam.iemail4!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail4)
                        }
                        if (myteam.iemail5!!.isNotEmpty() || myteam.iemail5!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail5)
                        }
                        //   pendingemail_list= mutableListOf(myteam.iemail2,myteam.iemail3,myteam.iemail4,myteam.iemail5)
                        pendingrecycler.data = pendingemail_list
                  //      invite2.text = myteam.iemail2
                   //     invite3.text = myteam.iemail3
                    //    invite4.text = myteam.iemail4
                    //    invite5.text = myteam.iemail5
                    } else if (currentUser?.email == postSnapshot.child("email3").value) {
                        myteam.key = postSnapshot.key
                        invitationkey = postSnapshot.key
                        myteam.teamname = postSnapshot.child("teamname").value.toString()
                        myteam.email1 = postSnapshot.child("email1").value.toString()
                        myteam.email2 = postSnapshot.child("email2").value.toString()
                        myteam.email3 = postSnapshot.child("email3").value.toString()
                        myteam.email4 = postSnapshot.child("email4").value.toString()
                        myteam.email5 = postSnapshot.child("email5").value.toString()
                        myteam.iemail2 = postSnapshot.child("iemail2").value.toString()
                        myteam.iemail3 = postSnapshot.child("iemail3").value.toString()
                        myteam.iemail4 = postSnapshot.child("iemail4").value.toString()
                        myteam.iemail5 = postSnapshot.child("iemail5").value.toString()
                        myteam.color = postSnapshot.child("color").value.toString()
                        if (myteam.iemail2!!.isNotEmpty() || myteam.iemail2!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail2)
                        }
                        if (myteam.iemail3!!.isNotEmpty() || myteam.iemail3!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail3)
                        }
                        if (myteam.iemail4!!.isNotEmpty() || myteam.iemail4!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail4)
                        }
                        if (myteam.iemail5!!.isNotEmpty() || myteam.iemail5!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail5)
                        }
                        //    pendingemail_list= mutableListOf(myteam.iemail2,myteam.iemail3,myteam.iemail4,myteam.iemail5)
                        pendingrecycler.data = pendingemail_list
                 //       invite2.text = myteam.iemail2
                 //       invite3.text = myteam.iemail3
                 //       invite4.text = myteam.iemail4
                  //      invite5.text = myteam.iemail5
                    } else if (currentUser?.email == postSnapshot.child("email4").value) {
                        myteam.key = postSnapshot.key
                        invitationkey = postSnapshot.key
                        myteam.teamname = postSnapshot.child("teamname").value.toString()
                        myteam.email1 = postSnapshot.child("email1").value.toString()
                        myteam.email2 = postSnapshot.child("email2").value.toString()
                        myteam.email3 = postSnapshot.child("email3").value.toString()
                        myteam.email4 = postSnapshot.child("email4").value.toString()
                        myteam.email5 = postSnapshot.child("email5").value.toString()
                        myteam.iemail2 = postSnapshot.child("iemail2").value.toString()
                        myteam.iemail3 = postSnapshot.child("iemail3").value.toString()
                        myteam.iemail4 = postSnapshot.child("iemail4").value.toString()
                        myteam.iemail5 = postSnapshot.child("iemail5").value.toString()
                        myteam.color = postSnapshot.child("color").value.toString()
                        if (myteam.iemail2!!.isNotEmpty() || myteam.iemail2!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail2)
                        }
                        if (myteam.iemail3!!.isNotEmpty() || myteam.iemail3!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail3)
                        }
                        if (myteam.iemail4!!.isNotEmpty() || myteam.iemail4!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail4)
                        }
                        if (myteam.iemail5!!.isNotEmpty() || myteam.iemail5!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail5)
                        }
                        //   pendingemail_list= mutableListOf(myteam.iemail2,myteam.iemail3,myteam.iemail4,myteam.iemail5)
                        pendingrecycler.data = pendingemail_list
                    //    invite2.text = myteam.iemail2
                    //    invite3.text = myteam.iemail3
                    //    invite4.text = myteam.iemail4
                    //    invite5.text = myteam.iemail5
                    } else if (currentUser?.email == postSnapshot.child("email5").value) {
                        myteam.key = postSnapshot.key
                        invitationkey = postSnapshot.key
                        myteam.teamname = postSnapshot.child("teamname").value.toString()
                        myteam.email1 = postSnapshot.child("email1").value.toString()
                        myteam.email2 = postSnapshot.child("email2").value.toString()
                        myteam.email3 = postSnapshot.child("email3").value.toString()
                        myteam.email4 = postSnapshot.child("email4").value.toString()
                        myteam.email5 = postSnapshot.child("email5").value.toString()
                        myteam.iemail2 = postSnapshot.child("iemail2").value.toString()
                        myteam.iemail3 = postSnapshot.child("iemail3").value.toString()
                        myteam.iemail4 = postSnapshot.child("iemail4").value.toString()
                        myteam.iemail5 = postSnapshot.child("iemail5").value.toString()
                        myteam.color = postSnapshot.child("color").value.toString()
                        if (myteam.iemail2!!.isNotEmpty() || myteam.iemail2!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail2)
                        }
                        if (myteam.iemail3!!.isNotEmpty() || myteam.iemail3!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail3)
                        }
                        if (myteam.iemail4!!.isNotEmpty() || myteam.iemail4!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail4)
                        }
                        if (myteam.iemail5!!.isNotEmpty() || myteam.iemail5!!.isNotBlank()) {
                            pendingemail_list.add(myteam.iemail5)
                        }
                        //   pendingemail_list= mutableListOf(myteam.iemail2,myteam.iemail3,myteam.iemail4,myteam.iemail5)
                        pendingrecycler.data = pendingemail_list
                     //   invite2.text = myteam.iemail2
                     //   invite3.text = myteam.iemail3
                   //     invite4.text = myteam.iemail4
                      //  invite5.text = myteam.iemail5
                    }
                }
                }

                userref.addValueEventListener(object : ValueEventListener {

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
                    }

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        flag=false
                        for (postSnapshot in dataSnapshot.children) {
                            if (postSnapshot.child("email").value==myteam.email1) {
                                flag=true
                                player1.text=postSnapshot.child("displayname").value.toString()
                                playericon1.text=postSnapshot.child("displayname").value.toString()
                            }
                            if (postSnapshot.child("email").value==myteam.email2) {
                                flag=true
                                player2.text=postSnapshot.child("displayname").value.toString()
                                playericon2.text=postSnapshot.child("displayname").value.toString()
                            }
                            if (postSnapshot.child("email").value==myteam.email3) {
                                flag=true
                                player3.text=postSnapshot.child("displayname").value.toString()
                                playericon3.text=postSnapshot.child("displayname").value.toString()
                            }
                            if (postSnapshot.child("email").value==myteam.email4) {
                                flag=true
                                player4.text=postSnapshot.child("displayname").value.toString()
                                playericon4.text=postSnapshot.child("displayname").value.toString()
                            }
                            if (postSnapshot.child("email").value==myteam.email5) {
                                flag=true
                                player5.text=postSnapshot.child("displayname").value.toString()
                                playericon5.text=postSnapshot.child("displayname").value.toString()
                            }
                        }
                    }

                })
                teamname.text=myteam.teamname
                myteamname=myteam.teamname
                if (myteam.color=="white") {
                    pl1icon.setImageResource(R.drawable.jerseysmol)
                    pl2icon.setImageResource(R.drawable.jerseysmol)
                    pl3icon.setImageResource(R.drawable.jerseysmol)
                    pl4icon.setImageResource(R.drawable.jerseysmol)
                    pl5icon.setImageResource(R.drawable.jerseysmol)
                }
                if (myteam.color=="blue") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_blue)
                    pl2icon.setImageResource(R.drawable.jerseysmol_blue)
                    pl3icon.setImageResource(R.drawable.jerseysmol_blue)
                    pl4icon.setImageResource(R.drawable.jerseysmol_blue)
                    pl5icon.setImageResource(R.drawable.jerseysmol_blue)
                }
                if (myteam.color=="lightblue") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    pl2icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    pl3icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    pl4icon.setImageResource(R.drawable.jerseysmol_lightblue)
                    pl5icon.setImageResource(R.drawable.jerseysmol_lightblue)
                }
                if (myteam.color=="brightgreen") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    pl2icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    pl3icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    pl4icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                    pl5icon.setImageResource(R.drawable.jerseysmol_brightgreen)
                }
                if (myteam.color=="brown") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_brown)
                    pl2icon.setImageResource(R.drawable.jerseysmol_brown)
                    pl3icon.setImageResource(R.drawable.jerseysmol_brown)
                    pl4icon.setImageResource(R.drawable.jerseysmol_brown)
                    pl5icon.setImageResource(R.drawable.jerseysmol_brown)
                }
                if (myteam.color=="darkgreen") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    pl2icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    pl3icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    pl4icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                    pl5icon.setImageResource(R.drawable.jerseysmol_darkgreen)
                }
                if (myteam.color=="grey") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_grey)
                    pl2icon.setImageResource(R.drawable.jerseysmol_grey)
                    pl3icon.setImageResource(R.drawable.jerseysmol_grey)
                    pl4icon.setImageResource(R.drawable.jerseysmol_grey)
                    pl5icon.setImageResource(R.drawable.jerseysmol_grey)
                }
                if (myteam.color=="orange") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_orange)
                    pl2icon.setImageResource(R.drawable.jerseysmol_orange)
                    pl3icon.setImageResource(R.drawable.jerseysmol_orange)
                    pl4icon.setImageResource(R.drawable.jerseysmol_orange)
                    pl5icon.setImageResource(R.drawable.jerseysmol_orange)
                }
                if (myteam.color=="purple") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_purple)
                    pl2icon.setImageResource(R.drawable.jerseysmol_purple)
                    pl3icon.setImageResource(R.drawable.jerseysmol_purple)
                    pl4icon.setImageResource(R.drawable.jerseysmol_purple)
                    pl5icon.setImageResource(R.drawable.jerseysmol_purple)
                }
                if (myteam.color=="red") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_red)
                    pl2icon.setImageResource(R.drawable.jerseysmol_red)
                    pl3icon.setImageResource(R.drawable.jerseysmol_red)
                    pl4icon.setImageResource(R.drawable.jerseysmol_red)
                    pl5icon.setImageResource(R.drawable.jerseysmol_red)
                }
                if (myteam.color=="yellow") {
                    pl1icon.setImageResource(R.drawable.jerseysmol_yellow)
                    pl2icon.setImageResource(R.drawable.jerseysmol_yellow)
                    pl3icon.setImageResource(R.drawable.jerseysmol_yellow)
                    pl4icon.setImageResource(R.drawable.jerseysmol_yellow)
                    pl5icon.setImageResource(R.drawable.jerseysmol_yellow)
                }
            }
        })


        editteambutton.setOnClickListener {
            if (flag==true) {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Select Jersey Color")
                val colorlist = arrayOf("White","Blue", "Green","Grey", "Light Blue","Orange","Purple","Red","Yellow","Dark Green")
                builder.setItems(colorlist) { dialog, which ->
                    when (which) {
                        0 -> {ref.child(myteam.key.toString()).child("color").setValue("white")}
                        1 -> { ref.child(myteam.key.toString()).child("color").setValue("blue") }
                        2 -> {ref.child(myteam.key.toString()).child("color").setValue("brightgreen")}
                        3 -> {ref.child(myteam.key.toString()).child("color").setValue("grey")}
                        4 -> {ref.child(myteam.key.toString()).child("color").setValue("lightblue")}
                        5 -> {ref.child(myteam.key.toString()).child("color").setValue("orange")}
                        6 -> {ref.child(myteam.key.toString()).child("color").setValue("purple")}
                        7 -> {ref.child(myteam.key.toString()).child("color").setValue("red")}
                        8-> {ref.child(myteam.key.toString()).child("color").setValue("yellow")}
                        9 -> {ref.child(myteam.key.toString()).child("color").setValue("darkgreen")}
                    }
                }
                val dialog = builder.create()
                dialog.show()
            }
        }


        var createteambutton:Button=view.findViewById(R.id.createteam_button)
        createteambutton.setOnClickListener {
            if (flag==false) {
                if (auth.currentUser != null) {
                    Navigation.findNavController(view).navigate(R.id.action_myteam_to_create_team)
                } else {
                    Navigation.findNavController(view)
                        .navigate(R.id.action_myteam_to_signUp_Login_Fragment)
                }
            }
            else {
                Toast.makeText(activity,"You have to leave your current team before making new one.",Toast.LENGTH_LONG).show()
            }
        }

        var jointeambutton:Button=view.findViewById(R.id.jointeam_button)
        jointeambutton.setOnClickListener {
            if (flag==false) {
                Navigation.findNavController(view).navigate(R.id.action_myteam_to_join_Team)
            }
            else {
                Toast.makeText(activity,"You have to leave your current team before joining new one.", Toast.LENGTH_LONG).show()
            }
        }

        val radapter= MyCreatedLTPadapter()
        view.findViewById<RecyclerView>(R.id.mycreatedLTP_recycleview).adapter=radapter

        challengesbutton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_myteam_to_myTeam_Challenges)
        }

        val progressbar: ProgressBar =view.findViewById(R.id.mycreatedLTP_progressbar)
        progressbar.isIndeterminate
        progressbar.setVisibility(View.VISIBLE)

        var details:MutableList<LookingtoPlayRoom> = mutableListOf()

        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                keyyy= mutableListOf()
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.exists() && currentUser?.uid==postSnapshot.child("uid").value) {
                        details.add(postSnapshot.getValue<LookingtoPlayRoom>()!!)
                        keyyy.add(postSnapshot.key.toString())
                    }

                }
                radapter.data=details
                progressbar.setVisibility(View.INVISIBLE)
            }

        })
    }
}
