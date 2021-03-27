package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.R
import com.romp.khel.daateeee
import com.romp.khel.stealthedeal
import com.romp.khel.teaminvitations

class TeamInvitationAdapter: RecyclerView.Adapter<teaminvitations>() {
    var data= listOf<String>()
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
        holder.teamname.text=item
    }

    override fun getItemCount()=data.size
}