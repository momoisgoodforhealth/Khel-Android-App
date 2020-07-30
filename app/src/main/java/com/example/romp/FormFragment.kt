package com.example.romp;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.Normalizer


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
        val loc: EditText = view.findViewById(R.id.editTextTextPersonName8)
        val contact: EditText = view.findViewById(R.id.editTextPhone2)
        val award: EditText = view.findViewById(R.id.editTextTextMultiLine3)
        val rd: EditText = view.findViewById(R.id.editTextTextMultiLine2)
        val add: EditText = view.findViewById(R.id.editTextTextMultiLine4)
        val butt: Button = view.findViewById(R.id.button)

        var tnamev = tname.text.toString().trim()
        var locv = loc.text.toString().trim()
        var contactv = contact.text.toString().trim()
        var awardv = award.text.toString().trim()
        var rdv = rd.text.toString().trim()
        var addv = add.text.toString().trim()


        var td = TournamentDetails()
        td.tname = tnamev
        td.loc = locv
        td.conc = contactv
        td.awar = awardv
        td.rud = rdv
        td.addi = addv


            butt.setOnClickListener {

                if (td.tname.isNullOrBlank() || td.loc.isNullOrBlank() || td.conc.isNullOrBlank() || td.awar.isNullOrBlank() || td.rud.isNullOrBlank() || td.addi.isNullOrBlank()) {
                    Toast.makeText(activity, "Field Empty", Toast.LENGTH_SHORT).show()

                }
                conditionref.push().setValue(td)

        }
    }
}



