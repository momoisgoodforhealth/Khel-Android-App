package com.romp.khel.Fragments;

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
    var conditionref: DatabaseReference = database.child("oi")


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
        val loc: EditText = view.findViewById(R.id.editTextTextPersonName8)
        val contact: EditText = view.findViewById(R.id.editTextPhone2)
        val award: EditText = view.findViewById(R.id.editTextTextMultiLine3)
        val rd: EditText = view.findViewById(R.id.editTextTextMultiLine2)
        val add: EditText = view.findViewById(R.id.editTextTextMultiLine4)
        val butt: Button = view.findViewById(R.id.button)
        val datepiku:DatePicker=view.findViewById(R.id.datepiku)
        val today = Calendar.getInstance()
        var tempdate:String


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
            tempdate="$i3/$i2/$i"
            date.text="$i3/$i2/$i"
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


