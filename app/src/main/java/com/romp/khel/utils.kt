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

class LTPViewHolder(val textView: CardView): RecyclerView.ViewHolder(textView) {
    var Lfutsalname:TextView=textView.findViewById(R.id.ltp_futsalname)
  //  var Llocation:TextView=textView.findViewById(R.id.ltp_location)
    var Ltime:TextView=textView.findViewById(R.id.ltp_time)
    var Lprice:TextView=textView.findViewById(R.id.ltp_price)
    var Lpcount:TextView=textView.findViewById(R.id.ltp_playercount)
}

class datecardview(textView: CardView): RecyclerView.ViewHolder(textView) {
    var dateval:TextView=textView.findViewById(R.id.dateval)
}

class stealthedeal(textView: CardView): RecyclerView.ViewHolder(textView)  {
    var venuename:TextView=textView.findViewById(R.id.stdcv_time)
}

class news(textView: CardView): RecyclerView.ViewHolder(textView) {
    var newstitle:TextView=textView.findViewById(R.id.news_title)
}

class venueviewholderval (textView: CardView): RecyclerView.ViewHolder(textView) {
    var venuename:TextView=textView.findViewById(R.id.venue_cardview_name)
    var venueloc:TextView=textView.findViewById(R.id.venue_cardview_location)
}