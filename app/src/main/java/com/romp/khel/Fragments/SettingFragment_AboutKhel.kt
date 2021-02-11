package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.romp.khel.R

class SettingFragment_AboutKhel : Fragment() {
    lateinit var auth: FirebaseAuth
    lateinit var testtext:TextView
    lateinit var testtext2:TextView
    lateinit var signin: GoogleSignInAccount
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_setting__about_khel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testtext=view.findViewById(R.id.yooooo)
        testtext2=view.findViewById(R.id.yooooo2)
      //  signin= GoogleSignIn.getLastSignedInAccount(activity)!!
        auth = Firebase.auth
        val currentUser = auth.currentUser
        testtext.text=currentUser?.uid
      //  if (signin!=null) {
       //    testtext2.text = signin.displayName
      //  }
    }
}