package com.romp.khel.Fragments

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.romp.khel.R
import com.romp.khel.dataclass.TournamentDetails
import com.romp.khel.venuekey
import com.romp.khel.vname

class VenueDetails : Fragment() {

    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("bookingstracking").child(venuekey.toString()).child("1").child("check")
    var ref:DatabaseReference = database.child("futsal").child(venuekey.toString())

    lateinit var datepicker:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { return inflater.inflate(R.layout.fragment_venue_details, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val venue_name=view.findViewById<TextView>(R.id.venue_name)
         datepicker=view.findViewById(R.id.venuedetails_datepicker)
        venue_name.text= vname
      /*  if (vname =="Kick Futsal Lalitpur") { conditionref=database.child("bookingstracking").child("mahalaxmistan").child("1").child("check") }
        if (vname =="Shankhamul Futsal") {conditionref=database.child("bookingstracking").child("mahalaxmistan").child("1").child("check")}
        if (vname =="Royal Futsal") {conditionref=database.child("bookingstracking").child("mahalaxmistan").child("1").child("check")}
        if (vname =="Shantinagar Futsal") {conditionref=database.child("bookingstracking").child("mahalaxmistan").child("1").child("check")}
        if (vname =="Prismatic Futsal and Recreation Center") {conditionref=database.child("bookingstracking").child("mahalaxmistan").child("1").child("check")}
        if (vname =="Dhobighat Futsal") {conditionref=database.child("bookingstracking").child("mahalaxmistan").child("1").child("check")}
        if (vname =="Maa Banglamukhi Futsal") {conditionref=database.child("bookingstracking").child("mahalaxmistan").child("1").child("check")}    */

        val time_six=view.findViewById<TextView>(R.id.time_six)
        val time_seven=view.findViewById<TextView>(R.id.time_seven)
        val time_eight=view.findViewById<TextView>(R.id.time_eight)
        val time_nine=view.findViewById<TextView>(R.id.time_nine)
        val time_ten=view.findViewById<TextView>(R.id.time_ten)
        val time_eleven=view.findViewById<TextView>(R.id.time_eleven)
        val time_twelve=view.findViewById<TextView>(R.id.time_twelve)
        val time_thirteen=view.findViewById<TextView>(R.id.time_thirteen)
        val time_fourteen=view.findViewById<TextView>(R.id.time_fourteen)
        val time_fifteen=view.findViewById<TextView>(R.id.time_fifteen)
        val time_sixteen=view.findViewById<TextView>(R.id.time_sixteen)
        val time_seventeen=view.findViewById<TextView>(R.id.time_seventeen)
        val time_eightteen=view.findViewById<TextView>(R.id.time_eighteen)

        val venue_location=view.findViewById<TextView>(R.id.venue_location)
        val venue_info=view.findViewById<TextView>(R.id.venue_info)

        val specialtitle:TextView=view.findViewById(R.id.venue_message_title)
        val specialbody:TextView=view.findViewById(R.id.venue_message_body)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    if (postSnapshot.key=="location") {venue_location.text=postSnapshot.value.toString()}
                    if (postSnapshot.key=="info") {venue_info.text=postSnapshot.value.toString()}
                    if (postSnapshot.key=="special") {specialbody.text=postSnapshot.child("body").value.toString() ; specialtitle.text=postSnapshot.child("title").value.toString() }
                }
            }

        })

        fun dataupdate () {
            conditionref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (postSnapshot in dataSnapshot.children) {
                        if (postSnapshot.key == "check1" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_six.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check1" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_six.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check2" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_seven.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check2" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_seven.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check3" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_eight.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check3" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_eight.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check4" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_nine.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check4" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_nine.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check5" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_ten.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check5" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_ten.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check6" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_eleven.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check6" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_eleven.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check7" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_twelve.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check7" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_twelve.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check8" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_thirteen.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check8" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_thirteen.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check9" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_fourteen.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check9" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_fourteen.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check10" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_fifteen.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check10" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_fifteen.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check11" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_sixteen.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check11" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_sixteen.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check12" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_seventeen.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check12" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_seventeen.setTextColor(
                                Color.parseColor("#EC2F2F")
                            )
                        }
                        if (postSnapshot.key == "check13" && postSnapshot.getValue()
                                .toString() == "1"
                        ) {
                            time_eightteen.setTextColor(
                                Color.parseColor("#46EC2F")
                            )
                        }
                        if (postSnapshot.key == "check13" && postSnapshot.getValue()
                                .toString() == "0"
                        ) {
                            time_eightteen.setTextColor(Color.parseColor("#EC2F2F")) }
                    }

                }

                override fun onCancelled(error: DatabaseError) {} })
        }
        dataupdate()


        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Select Date")
        val day = arrayOf("Today","Tommorrow", "2 Days Later","3 Days Later", "4 Days Later", "5 Days Later", "6 Days Later", "7 Days Later")
        builder.setItems(day) { dialog, which ->
            when (which) {
                0 -> {conditionref=database.child("bookingstracking").child(venuekey.toString()).child("1").child("check") ; dataupdate()}
                1 -> {conditionref=database.child("bookingstracking").child(venuekey.toString()).child("2").child("check") ; dataupdate()}
                2 -> {conditionref=database.child("bookingstracking").child(venuekey.toString()).child("3").child("check") ; dataupdate()}
                3 -> {conditionref=database.child("bookingstracking").child(venuekey.toString()).child("4").child("check") ;dataupdate()}
                4 -> {conditionref=database.child("bookingstracking").child(venuekey.toString()).child("5").child("check") ; dataupdate()}
                5 -> {conditionref=database.child("bookingstracking").child(venuekey.toString()).child("6").child("check") ; dataupdate()}
                6 -> {conditionref=database.child("bookingstracking").child(venuekey.toString()).child("7").child("check"); dataupdate()}
                7 -> {conditionref=database.child("bookingstracking").child(venuekey.toString()).child("8").child("check") ; dataupdate()}
            }
        }
        datepicker.setOnClickListener {
            val dialog = builder.create()
            dialog.show()
        }



    }
}