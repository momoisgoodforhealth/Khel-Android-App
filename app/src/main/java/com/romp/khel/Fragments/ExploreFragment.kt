package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.ktx.startUpdateFlowForResult
import com.romp.khel.R

class ExploreFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val MY_REQUEST_CODE=1
        // Creates instance of the manager.
        val appUpdateManager = AppUpdateManagerFactory.create(requireContext())

// Returns an intent object that you use to check for an update.
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo

// Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                // Request the update.
                appUpdateManager.startUpdateFlowForResult(
                    // Pass the intent that is returned by 'getAppUpdateInfo()'.
                    appUpdateInfo,
                    // Or 'AppUpdateType.FLEXIBLE' for flexible updates.
                    AppUpdateType.IMMEDIATE,
                    // The current activity making the update request.
                    this,
                    // Include a request code to later monitor this update request.
                    MY_REQUEST_CODE)
            }
        }


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
