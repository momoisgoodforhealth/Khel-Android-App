package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.romp.khel.R

class ExploreFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val button: Button =view.findViewById(R.id.explore_frag_tourbutton)
        button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_exploreFragment_to_tournaments)
        }

        val button2:Button=view.findViewById(R.id.explore_frag_ctvmbutton)
        button2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_exploreFragment_to_comingsoon)
        }

        val button3:Button=view.findViewById(R.id.explore_frag_fibbutton)
        button3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_exploreFragment_to_booking)
        }

        val button4:Button=view.findViewById(R.id.explore_frag_ltpbutton)
        button4.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_exploreFragment_to_lookingtoPlay)
        }

        val button5:Button=view.findViewById(R.id.explore_frag_vleaguebutton)
        button5.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_exploreFragment_to_comingsoon)
        }
    }
}
