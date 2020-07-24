package com.example.romp;

import android.app.Activity;
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class FormFragment : Fragment() {
     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         return inflater.inflate(R.layout.fragment_form, container, false)
     }

 }



