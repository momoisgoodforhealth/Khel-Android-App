package com.romp.khel.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.romp.khel.R
import com.romp.khel.dataclass.Venue
import com.romp.khel.adapters.VenueRecycleViewAdapter
import com.romp.khel.dataclass.TournamentDetails


class Booking : Fragment() {

    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("futsal")

    lateinit var alertbutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_booking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Sort By District")

        alertbutton=view.findViewById(R.id.alert)

        val searchtext:EditText=view.findViewById(R.id.search_editext)


        var details:MutableList<Venue> = mutableListOf()
        var details_ktm:MutableList<Venue> = mutableListOf()
        var details_lal:MutableList<Venue> = mutableListOf()
        var details_pok:MutableList<Venue> = mutableListOf()
        var details_bhk:MutableList<Venue> = mutableListOf()
        var details_search:MutableList<Venue> = mutableListOf()

        val adapter=VenueRecycleViewAdapter()
        view.findViewById<RecyclerView>(R.id.venues_recyclerview).adapter=adapter

        val progressbar=view.findViewById<ProgressBar>(R.id.bookings_progressbar)
        progressbar.setVisibility(View.VISIBLE)

        fun searchfun () {

            adapter.data=details_search
            adapter.notifyDataSetChanged()
        }
        var blanktest=true


        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    var duke=Venue()
                    duke.futsalname=postSnapshot.child("futsalname").value.toString()
                    duke.picurl=postSnapshot.child("picurl").value.toString()
                    duke.location=postSnapshot.child("location").value.toString()
                    duke.phone=postSnapshot.child("phone").value.toString()
                    duke.district=postSnapshot.child("district").value.toString()
                    duke.key=postSnapshot.key
                    details.add(duke)
                    if (duke.district=="Kathmandu"){details_ktm.add(duke)}
                    if (duke.district=="Pokhara"){details_pok.add(duke)}
                    if (duke.district=="Lalitpur"){details_lal.add(duke)}
                    if (duke.district=="Bhaktapur"){details_bhk.add(duke)}

                    searchtext.addTextChangedListener(object : TextWatcher {
                        override fun afterTextChanged(s: Editable?) {
                        //    Toast.makeText(activity,"CHANGE NOTE",Toast.LENGTH_SHORT).show()
                                if (s.toString().isNullOrBlank()) {blanktest=true}
                                if (duke.futsalname!!.toLowerCase().contains(s.toString().toLowerCase()) && s.toString().isNotBlank() && s.toString().isNotEmpty()) {
                           //         Toast.makeText(activity,duke.futsalname,Toast.LENGTH_SHORT).show()
                                    adapter.data= emptyList()
                                    details_search.add(duke)
                                //    Toast.makeText(activity,details_search[0].futsalname,Toast.LENGTH_SHORT).show()
                                    blanktest=false
                                    searchfun()
                                }
                        }

                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        }

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        }
                    })

                }
                if (blanktest==true) {adapter.data=details }
                else {
                    adapter.data=details_search
                Toast.makeText(activity,"TAGGED",Toast.LENGTH_SHORT).show()}


                val loc = arrayOf("Kathmandu","Pokhara", "Lalitpur","Bhaktapur", "All")
                builder.setItems(loc) { dialog, which ->
                    when (which) {

                        0 -> {adapter.data=details_ktm}
                        1 -> {adapter.data=details_pok}
                        2 -> {adapter.data=details_lal}
                        3 -> {adapter.data=details_bhk}
                        4 -> {adapter.data=details}
                    }
                }
                alertbutton.setOnClickListener {
                    val dialog = builder.create()
                    dialog.show()
                }
                progressbar.setVisibility(View.INVISIBLE)

            }

        })





    }
}