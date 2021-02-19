package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.navigation.Navigation
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.romp.khel.R


class After_Login : Fragment() {
    lateinit var name: TextView
    lateinit var email: TextView
    lateinit var id: TextView
    lateinit var signin: GoogleSignInAccount
    lateinit var signoutbutton: Button


    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_after__login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name= view.findViewById(R.id.hello)
        email=view.findViewById(R.id.hi)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
        var mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        signoutbutton=view.findViewById(R.id.signout_button2)
        signin= GoogleSignIn.getLastSignedInAccount(activity)!!
        if (signin!=null) {
            name.text=signin.displayName
            email.text=signin.email
        }
        signoutbutton.setOnClickListener {
            mGoogleSignInClient.signOut()
            Firebase.auth.signOut()
            view?.let { Navigation.findNavController(it).navigate(R.id.action_after_Login_to_signUp_Login_Fragment) }
        }



    }

}