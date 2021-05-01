package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.R
import com.romp.khel.dataclass.TeamChallengeDetails
import com.romp.khel.myteam_acceptedchallengeposition
import com.romp.khel.myteamacceptedchallenges
import com.romp.khel.myteamchallenges

class Myteam_AcceptedChallengesAdapter: RecyclerView.Adapter<myteamacceptedchallenges>() {
    var data= listOf<TeamChallengeDetails>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myteamacceptedchallenges {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.myteam_acceptedchallenges_cardview, parent, false) as CardView
        return myteamacceptedchallenges(view)
    }

    override fun onBindViewHolder(holder: myteamacceptedchallenges, position: Int) {
        val item=data[position]
        holder.mtc_ac_teamname.text=item.team1+" VS "+item.team2
        holder.mtc_ac_memo.text=item.addinfo
        holder.mtc_ac_date.text=item.date
        holder.mtc_ac_time.text=item.starttime+"-"+item.endtime
        myteam_acceptedchallengeposition=holder.adapterPosition
    }

    override fun getItemCount()=data.size
}