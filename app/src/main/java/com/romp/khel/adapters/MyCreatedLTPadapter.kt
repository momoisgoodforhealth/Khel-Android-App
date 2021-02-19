package com.romp.khel.adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.LTPViewHolder
import com.romp.khel.R
import com.romp.khel.dataclass.LookingtoPlayRoom
import com.romp.khel.timeeeee1
import com.romp.khel.timeeeee2

class MyCreatedLTPadapter:RecyclerView.Adapter<LTPViewHolder>() {

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

    override fun onBindViewHolder(holder: LTPViewHolder, position: Int) {
        val item=data[position]
        holder.Lfutsalname.text=item.futsalname
        holder.Llocation.text=item.location
        holder.Ltime.text=item.time.toString()
        holder.Lprice.text=item.pricepp
        holder.Lpcount.text= item.playercount.toString()+"/"+item.playerlimit.toString()

        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_myteam_to_myCreated_LTP_Details)
            timeeeee1=item.playercount
            timeeeee2=item.playerlimit
        }
    }

    override fun getItemCount()=data.size
}