package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.romp.khel.*
import com.romp.khel.Fragments.numbo
import com.romp.khel.R
import com.romp.khel.dataclass.jteam
import com.romp.khel.dataclass.team

class TeamInvitationAdapter: RecyclerView.Adapter<teaminvitations>() {
    var data= listOf<jteam>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): teaminvitations {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.team_invitations_cardview, parent, false) as CardView
        return teaminvitations(view)
    }

    override fun onBindViewHolder(holder: teaminvitations, position: Int) {
        val item=data[position]
        var database = FirebaseDatabase.getInstance().getReference()
        var ref: DatabaseReference = database.child("team").child(item.key.toString())

        holder.teamname.text=item.teamname
        holder.cancelbutton.setOnClickListener {
            jtdposition=holder.adapterPosition
            Navigation.findNavController(it).navigate(R.id.action_join_Team_to_join_Team_Detalis)
            //    ref.removeValue()
        }
    }

    override fun getItemCount()=data.size
}