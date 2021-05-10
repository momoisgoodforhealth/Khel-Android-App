package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.romp.khel.R
import com.romp.khel.invitationkey
import com.romp.khel.pendinginvitation


class PendingInvitationAdapter: RecyclerView.Adapter<pendinginvitation>() {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    var database = FirebaseDatabase.getInstance().getReference()
    var dude=""
    var ref: DatabaseReference = database.child("teams").child(invitationkey.toString())
    var data= listOf<String?>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pendinginvitation {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.pending_invitations_cardview, parent, false) as CardView
        return pendinginvitation(view)
    }

    override fun onBindViewHolder(holder: pendinginvitation, position: Int) {
        val item=data[position]
        holder.pendingemail.text=item
        var editemail=holder.pendingemailedit.text
        ref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (item==dataSnapshot.child("iemail1").value) {
                    dude="iemail1"
                    holder.editbutton.setOnClickListener { v ->
                        //  Toast.makeText(v.context,dude,Toast.LENGTH_SHORT).show()
                        editemail=holder.pendingemailedit.text
                        ref.child(dude).setValue(editemail.toString()).addOnSuccessListener {
                            Toast.makeText(v.context,"Edit Success",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                if (item==dataSnapshot.child("iemail2").value) {
                    dude="iemail2"
                    holder.editbutton.setOnClickListener { v ->
                      //  Toast.makeText(v.context,dude,Toast.LENGTH_SHORT).show()
                        editemail=holder.pendingemailedit.text
                        ref.child(dude).setValue(editemail.toString()).addOnSuccessListener {
                            Toast.makeText(v.context,"Edit Success",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                if (item==dataSnapshot.child("iemail3").value) {
                    dude="iemail3"
                    holder.editbutton.setOnClickListener { v ->
                     //   Toast.makeText(v.context,dude,Toast.LENGTH_SHORT).show()
                        editemail=holder.pendingemailedit.text
                        ref.child(dude).setValue(editemail.toString()).addOnSuccessListener {
                            Toast.makeText(v.context,"Edit Success",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                if (item==dataSnapshot.child("iemail4").value) {
                    dude="iemail4"
                    holder.editbutton.setOnClickListener { v ->
                    //    Toast.makeText(v.context,dude,Toast.LENGTH_SHORT).show()
                        editemail=holder.pendingemailedit.text
                        ref.child(dude).setValue(editemail.toString()).addOnSuccessListener {
                            Toast.makeText(v.context,"Edit Success",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                if (item==dataSnapshot.child("iemail5").value) {
                    dude="iemail5"
                    holder.editbutton.setOnClickListener { v ->
                    //    Toast.makeText(v.context,dude,Toast.LENGTH_SHORT).show()
                        editemail=holder.pendingemailedit.text
                        ref.child(dude).setValue(editemail.toString()).addOnSuccessListener {
                            Toast.makeText(v.context,"Edit Success",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
     //   holder.editbutton.setOnClickListener { v ->

        //    Toast.makeText(v.context,dude,Toast.LENGTH_SHORT).show()
         //   ref.child(dude).setValue(editemail.toString()).addOnSuccessListener {
          //      Toast.makeText(v.context,"Edit Success",Toast.LENGTH_SHORT).show()
           // }
     //   }
    }

    override fun getItemCount()=data.size
}