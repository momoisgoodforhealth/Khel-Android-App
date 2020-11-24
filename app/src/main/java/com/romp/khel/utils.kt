package com.romp.khel

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(val textView: CardView): RecyclerView.ViewHolder(textView) {
    var text:TextView=textView.findViewById(R.id.cvTitle)
    var text2:TextView=textView.findViewById(R.id.cvAwards)
    var text3:TextView=textView.findViewById(R.id.cvDate)
    var text4:TextView=textView.findViewById(R.id.cvLocation)


}