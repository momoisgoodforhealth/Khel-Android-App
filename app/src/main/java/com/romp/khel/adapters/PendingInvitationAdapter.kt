package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.R
import com.romp.khel.pendinginvitation

class PendingInvitationAdapter: RecyclerView.Adapter<pendinginvitation>() {
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
    }

    override fun getItemCount()=data.size
}