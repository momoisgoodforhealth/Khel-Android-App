package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.R
import com.romp.khel.challengeposition
import com.romp.khel.dataclass.TeamChallengeDetails
import com.romp.khel.myteam_challengeposition
import com.romp.khel.myteamchallenges


class Myteam_ChallengesAdapter: RecyclerView.Adapter<myteamchallenges>() {
    var data= listOf<TeamChallengeDetails>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myteamchallenges {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.myteam_challenges_cardview, parent, false) as CardView
        return myteamchallenges(view)
    }

    override fun onBindViewHolder(holder: myteamchallenges, position: Int) {
        val item=data[position]
        holder.mtc_teamname.text=item.team1
        holder.mtc_memo.text=item.addinfo
        holder.mtc_date.text=item.date
        holder.mtc_time.text=item.starttime+"-"+item.endtime
        myteam_challengeposition=holder.adapterPosition

        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_myTeam_Challenges_to_myTeam_ChallengeDetails)
        }
    }

    override fun getItemCount()=data.size
}