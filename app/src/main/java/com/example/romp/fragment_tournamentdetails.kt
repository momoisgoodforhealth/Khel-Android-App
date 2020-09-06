package com.example.romp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

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
        title.text= tname
        des.text= tdes
        award.text= taward
        date.text= tdate
        rule.text= trules
        conc.text= tconc
        loc.text= tloc
    }
}