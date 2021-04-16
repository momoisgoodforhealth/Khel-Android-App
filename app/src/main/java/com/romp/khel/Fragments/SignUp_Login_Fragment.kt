package com.romp.khel.Fragments

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.romp.khel.R
import timber.log.Timber


class SignUp_Login_Fragment : Fragment() {

    lateinit var data: Intent
    lateinit var auth: FirebaseAuth


    fun updateUI(account: GoogleSignInAccount?) {
        if (account != null) {
        //    Toast.makeText(activity, "You Signed In Successfully", Toast.LENGTH_LONG).show()
            view?.let { Navigation.findNavController(it).navigate(R.id.action_signUp_Login_Fragment_to_after_Login) }
        } else {
        //    Toast.makeText(activity, "Sign In Unsuccessful", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { return inflater.inflate(R.layout.fragment_sign_up__login_, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
        var mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        val signinbutton=view.findViewById<SignInButton>(R.id.sign_in_button)
        signinbutton.setOnClickListener { v ->
            fun signIn(){
                val signInIntent:Intent = mGoogleSignInClient.getSignInIntent()
                startActivityForResult(signInIntent, 1)
            }
            when (v.id) {
                signinbutton.id -> signIn()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(activity)
        updateUI(account)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 1) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Timber.i("firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
                handleSignInResult(task)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(ContentValues.TAG, "Google sign in failed", e)
                // ...
            }
        }
    }

    fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        activity?.let {
            auth.signInWithCredential(credential)
                .addOnCompleteListener(it) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Timber.i("signInWithCredential:success")
                        val user = auth.currentUser
                        //   updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(ContentValues.TAG, "signInWithCredential:failure", task.exception)
                        // ...
                        view?.let { it1 -> Snackbar.make(it1, "Authentication Failed.", Snackbar.LENGTH_SHORT).show() }
                        updateUI(null)
                    }

                    // ...
                }
        }

    }

    fun handleSignInResult(completedTask : Task<GoogleSignInAccount>) {
        try {
            var account : GoogleSignInAccount= completedTask.result!!
            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e:ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            updateUI(null)
        }
    }
}