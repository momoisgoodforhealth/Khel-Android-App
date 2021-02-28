package com.romp.khel.Fragments;

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.IgnoreExtraProperties
import com.romp.khel.R
import java.util.*


class FormFragment : Fragment() {

    var database = FirebaseDatabase.getInstance().getReference()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val tname: EditText = view.findViewById(R.id.editTextTextPersonName3)
        val date:TextView=view.findViewById(R.id.editdatetext)
        val selloc:Button=view.findViewById(R.id.tourform_selectvenue)
        val loc: TextView = view.findViewById(R.id.editTextTextPersonName8)
        val contact: EditText = view.findViewById(R.id.editTextPhone2)
        val award: EditText = view.findViewById(R.id.editTextTextMultiLine3)
        val rd: EditText = view.findViewById(R.id.editTextTextMultiLine2)
        val add: EditText = view.findViewById(R.id.editTextTextMultiLine4)
        val butt: Button = view.findViewById(R.id.button)
        val datepiku:DatePicker=view.findViewById(R.id.datepiku)
        val today = Calendar.getInstance()

        var day:String?=null
        var month:String?=null

        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Select Venue")
        val venues = arrayOf("Kick Futsal Lalitpur","Shankhamul Futsal", "Royal Futsal","Shantinagar Futsal", "Prismatic Futsal and Recreation Center", "Dhobighat Futsal", "Maa Banglamukhi Futsal")
        builder.setItems(venues) { dialog, which ->
            when (which) {
                0 -> {loc.text="Kick Futsal Lalitpur"}
                1 -> {loc.text="Shankhamul Futsal"}
                2 -> {loc.text="Royal Futsal" }
                3 -> {loc.text="Shantinagar Futsal"}
                4 -> {loc.text="Prismatic Futsal and Recreation Center"}
                5 -> {loc.text="Dhobighat Futsal" }
                6 -> {loc.text="Maa Banglamukhi Futsal"}
            }
        }
        selloc.setOnClickListener {
            val dialog = builder.create()
            dialog.show()
        }




        @IgnoreExtraProperties
        data class TournamentDetails(
            var TournamentName: String? = "",
            var datev:String?="",
            var Location: String? = "",
            var Contact: String? = "",
            var Award: String? = "",
            var Rules: String? = "",
            var Additional: String? = ""
        )

        datepiku.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)) {v,i,i2,i3 ->
            var ii3=i3.toString()
            var ie2=i2+1
            var ii2=ie2.toString()
            if (i3<10) { ii3="0"+i3 }
            if (ie2<10) { ii2="0"+ie2}
            date.text="$ii3/$ii2/$i"
        }



        fun writeNewTournament(
            nn: String,
            dd:String,
            ll: String,
            cc: String,
            aww: String,
            rr: String,
            aa: String
        ) {
            val tour = TournamentDetails(nn,dd, ll, cc, aww, rr, aa)
            database.child("tournaments").push().setValue(tour)
                .addOnSuccessListener {
                    Navigation.findNavController(view).navigate(R.id.action_formFragment_to_tournamentSuccess)
                }
                .addOnFailureListener {
                    Toast.makeText(activity,"ERROR: $it", Toast.LENGTH_LONG).show()
                }
        }



        butt.setOnClickListener {

            if (tname.text.toString().trim().isBlank() || loc.text.toString().trim()
                    .isBlank() || contact.text.toString().trim().isBlank() || award.text.toString()
                    .trim().isBlank() || rd.text.toString().trim().isBlank() || add.text.toString()
                    .trim().isBlank() || date.text.toString().trim().isBlank()
            ) {
                Toast.makeText(activity, "Complete All The Fields", Toast.LENGTH_LONG).show()
            } else {

                writeNewTournament(
                    tname.text.toString().trim(),
                    date.text.toString().trim(),
                    loc.text.toString().trim(),
                    contact.text.toString().trim(),
                    award.text.toString().trim(),
                    rd.text.toString().trim(),
                    add.text.toString().trim()
                )

            }
        }
    }
}


