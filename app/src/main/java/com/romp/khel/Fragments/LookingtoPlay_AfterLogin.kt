package com.romp.khel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.romp.khel.R
import java.text.SimpleDateFormat
import java.util.*


class LookingtoPlay_AfterLogin : Fragment() {
    lateinit var name:TextView
    lateinit var email:TextView
    lateinit var boom:TextView
    lateinit var boom2:TextView
    lateinit var id:TextView
    lateinit var auth: FirebaseAuth
    lateinit var signin:GoogleSignInAccount
    lateinit var signoutbutton:Button
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lookingto_play__after_login, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        boom=view.findViewById(R.id.bitch_lasagna)
        boom2=view.findViewById(R.id.bush)
        name= view.findViewById(R.id.hello)
        email=view.findViewById(R.id.hi)
        id=view.findViewById(R.id.bye)
        val date:SimpleDateFormat= SimpleDateFormat("MMM dd")
        val _date:String="Feb 04"
        var realdate: Date = date.parse(_date)
        val time:SimpleDateFormat=SimpleDateFormat("K:mm a")
        val _time:String="5:00 PM"
        var realtime:Date = time.parse(_time)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
        var mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        signoutbutton=view.findViewById(R.id.signout_button2)
        signin= GoogleSignIn.getLastSignedInAccount(activity)!!
        if (signin!=null) {
            name.text=signin.displayName
            email.text=signin.email
            id.text=currentUser?.uid
            boom.text=date.format(realdate).toString()
            boom2.text=time.format(realtime).toString()
        }
        signoutbutton.setOnClickListener {
               mGoogleSignInClient.signOut()
                Firebase.auth.signOut()
            view?.let { Navigation.findNavController(it).navigate(R.id.action_lookingtoPlay_AfterLogin_to_signUp_Login_Fragment2) }
        }



    }
}