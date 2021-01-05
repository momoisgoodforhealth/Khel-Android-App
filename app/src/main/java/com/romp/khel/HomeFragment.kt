package com.romp.khel

import adapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue


class HomeFragment : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    var conditionref: DatabaseReference = database.child("tournaments")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val radapter=adapter()
         view.findViewById<RecyclerView>(R.id.recycle).adapter=radapter


        val progressbar:ProgressBar=view.findViewById(R.id.progressBar)
        progressbar.isIndeterminate
            progressbar.setVisibility(View.VISIBLE);


        val button: Button = view.findViewById(R.id.create_tournament_button)
        button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_formFragment)
        }

     //   var testdata:MutableList<TextView> = mutableListOf(view.findViewById(R.id.textView2),view.findViewById(R.id.test),view.findViewById(R.id.test2),view.findViewById(R.id.test3),view.findViewById(R.id.test4))
        var details:MutableList<TournamentDetails> = mutableListOf()



     //   var num:Int




        conditionref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"onCancelled called",Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
          //      num = 0
                for (postSnapshot in dataSnapshot.children) {
         //           testdata[num].text = postSnapshot.child("tournamentName").getValue<String>()
                    details.add(postSnapshot.getValue<TournamentDetails>()!!)
          //          num++
                }
              //  Toast.makeText(activity,"size: ${details.size}", Toast.LENGTH_LONG).show()
                radapter.data=details
                progressbar.setVisibility(View.INVISIBLE)

            }

        })




    }
    }
