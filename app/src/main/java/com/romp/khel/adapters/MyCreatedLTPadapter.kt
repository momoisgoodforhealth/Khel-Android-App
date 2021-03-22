package com.romp.khel.adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.romp.khel.*
import com.romp.khel.dataclass.LookingtoPlayRoom

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
        holder.Lfutsalname.text=item.futsalname+", "+item.location
      //  holder.Llocation.text=item.location
        holder.Ltime.text=item.time.toString()
        holder.Lprice.text="Rs."+item.pricepp
        holder.Lpcount.text= item.playercount.toString()+"/"+item.playerlimit.toString()

        holder.itemView.setOnClickListener {
            positionn=holder.adapterPosition
            Navigation.findNavController(it).navigate(R.id.action_myteam_to_myCreated_LTP_Details)
            timeeeee1=item.playercount
            timeeeee2=item.playerlimit
        }
    }

    override fun getItemCount()=data.size
}