package com.romp.khel.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.romp.khel.*

class fragment_tournamentdetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tournamentdetails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title:TextView=view.findViewById(R.id.tdtext)
        val des:TextView=view.findViewById(R.id.tddes)
        val award:TextView=view.findViewById(R.id.tdaward)
        val date:TextView=view.findViewById(R.id.tddate)
        val rule:TextView=view.findViewById(R.id.tdrules)
        val conc:TextView=view.findViewById(R.id.tdconc)
        val loc:TextView=view.findViewById(R.id.tdloc)
        val whatsapp:Button=view.findViewById(R.id.tour_whatsappbutton)
        val call:Button=view.findViewById(R.id.tour_callbutton)

        title.text= tname
        des.text= tdes
        award.text= taward
        date.text= tdate
        rule.text= trules
        conc.text= tconc
        loc.text= tloc

        whatsapp.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=+977$tconc&text=Hello! I saw your Tournament listing in Khel. I am interested and would like to inquire further.")
            startActivity(intent)
        }

        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL);
            intent.data = Uri.parse("tel:$tconc")
            startActivity(intent)
        }
    }
}