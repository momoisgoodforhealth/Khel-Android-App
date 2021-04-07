package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.R
import com.romp.khel.teamchallenges

class ChallengeTeamAdapter: RecyclerView.Adapter<teamchallenges>() {
    var data= listOf<String>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): teamchallenges {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.team_challenge_cardview, parent, false) as CardView
        return teamchallenges(view)
    }

    override fun onBindViewHolder(holder: teamchallenges, position: Int) {
        val item=data[position]
        holder.challengeteamname.text=item
    }

    override fun getItemCount()=data.size

}