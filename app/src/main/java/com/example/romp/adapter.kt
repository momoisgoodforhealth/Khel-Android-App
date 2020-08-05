import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.romp.MyViewHolder
import com.example.romp.TournamentDetails

class adapter: RecyclerView.Adapter<MyViewHolder>() {
    var data= listOf<TournamentDetails>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        TODO("Not yet implemented")
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

}

