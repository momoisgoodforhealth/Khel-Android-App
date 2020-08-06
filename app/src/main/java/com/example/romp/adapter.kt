import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.romp.MyViewHolder
import com.example.romp.R
import com.example.romp.TournamentDetails

class adapter: RecyclerView.Adapter<MyViewHolder>() {
    var data= listOf<TournamentDetails>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.cardview, parent, false) as CardView
        return MyViewHolder(view)

    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item=data[position]
        holder.text.text=item.TournamentName
        holder.text2.text=item.Award
        holder.text3.text=item.datev
        holder.text4.text=item.Location
    }

}

