package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.R
import com.romp.khel.dataclass.TeamChallengeDetails
import com.romp.khel.myteam_cfmtposition
import com.romp.khel.myteamcfmt

class Myteam_CFMT_Adapter: RecyclerView.Adapter<myteamcfmt>() {
    var data= listOf<TeamChallengeDetails>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myteamcfmt {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.myteam_cfmt_cardview, parent, false) as CardView
        return myteamcfmt(view)
    }

    override fun onBindViewHolder(holder: myteamcfmt, position: Int) {
        val item=data[position]
        holder.mtc_cfmt_teamname.text=item.team2
        holder.mtc_cfmt_memo.text=item.addinfo
        holder.mtc_cfmt_date.text=item.date
        holder.mtc_cfmt_time.text=item.starttime+"-"+item.endtime
        myteam_cfmtposition=holder.adapterPosition
    }

    override fun getItemCount()=data.size
}