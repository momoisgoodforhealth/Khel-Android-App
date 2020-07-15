package com.example.romp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ExploreFragment : Fragment() {
    lateinit var homeFragment: ExploreFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button =view.findViewById(R.id.explore_frag_tourbutton)
        button.setOnClickListener {
            var fr= fragmentManager!!.beginTransaction()
            fr.replace((R.id.fragment_container),homeFragment)

        }
    }
}
