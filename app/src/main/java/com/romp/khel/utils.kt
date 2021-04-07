package com.romp.khel

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

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

class newsviewholder(textView: CardView): RecyclerView.ViewHolder(textView) {
    var newstitle:TextView=textView.findViewById(R.id.news_title)
    var newspic:ImageView=textView.findViewById(R.id.iimage)
    var newstext:TextView=textView.findViewById(R.id.news_text)
}

class venueviewholderval (textView: CardView): RecyclerView.ViewHolder(textView) {
    var venuename:TextView=textView.findViewById(R.id.venue_cardview_name)
    var venueloc:TextView=textView.findViewById(R.id.venue_cardview_location)
    var venueimg:ImageView= textView.findViewById(R.id.venueimg)
}

class teaminvitations  (textView: CardView): RecyclerView.ViewHolder(textView) {
    var teamname:TextView=textView.findViewById(R.id.ticv_teamname)
    var button:Button=textView.findViewById(R.id.ticv_button)
}

class teamchallenges (textView: CardView): RecyclerView.ViewHolder(textView){
    var challengeteamname:TextView=textView.findViewById(R.id.tcc_teamname)
    var challengebutton:Button=textView.findViewById(R.id.tcc_challengebutton)
}