package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.romp.khel.R


class SettingFragment : Fragment() {
    lateinit var aboutbutton:Button
    lateinit var myaccountbutton:Button
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aboutbutton=view.findViewById(R.id.aboutbutton)
        myaccountbutton=view.findViewById(R.id.myaccount_button)
        aboutbutton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_settingFragment_to_settingFragment_AboutKhel)
        }
        myaccountbutton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_settingFragment_to_signUp_Login_Fragment)
        }
    }
}