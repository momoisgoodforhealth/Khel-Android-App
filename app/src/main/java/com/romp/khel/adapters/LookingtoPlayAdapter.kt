package com.romp.khel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.*
import com.romp.khel.dataclass.LookingtoPlayRoom

class LookingtoPlayAdapter: RecyclerView.Adapter<LTPViewHolder>() {

    var data= listOf<LookingtoPlayRoom>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LTPViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.ltp_cardview, parent, false) as CardView
        return LTPViewHolder(view)
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: LTPViewHolder, position: Int) {
        val item=data[position]
        holder.Lfutsalname.text=item.futsalname
        holder.Llocation.text=item.location
        holder.Ltime.text=item.time.toString()
        holder.Lprice.text="Rs."+item.pricepp
        holder.Lpcount.text= item.playercount.toString()+"/"+item.playerlimit.toString()

        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_lookingtoPlay_to_LTP_Details)
            ltpfutsalname=item.futsalname
            ltpdate=item.date
            ltptime=item.time.toString()
            ltplocation=item.location
            ltppricepp="Rs."+item.pricepp
            ltpplayercount=item.playercount
            ltpplayerlimit=item.playerlimit
            ltpcontact=item.contact.toString()
            ltpaddinfo=item.additionalinfo
        }

    }


}