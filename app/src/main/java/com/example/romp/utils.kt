package com.example.romp

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(val textView: CardView): RecyclerView.ViewHolder(textView) {
    var text:TextView=textView.findViewById(R.id.cardviewtext)

}


 /*   fun LogRecycleView(){
    var FirebaseRecyclerAdapter=object : FirebaseRecyclerAdapter<TournamentDetails, MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(
            holder: MyViewHolder,
            position: Int,
            model: TournamentDetails
        ) {
            TODO("Not yet implemented")
        }


    }
}   */