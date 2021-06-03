package com.romp.khel

import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
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
    var venuename:TextView=textView.findViewById(R.id.stdcv_name)
    var datetime:TextView=textView.findViewById(R.id.stdcv_datetime)
    var price:TextView=textView.findViewById(R.id.stdcv_price)
    var image:ImageView=textView.findViewById(R.id.std_imageview)
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
    var challengeswin:TextView=textView.findViewById(R.id.tcc_win)
    var challengesloss:TextView=textView.findViewById(R.id.tcc_loss)
    var challengesdraw:TextView=textView.findViewById(R.id.tcc_draw)
}

class myteamchallenges  (textView: CardView): RecyclerView.ViewHolder(textView){
    var mtc_teamname:TextView=textView.findViewById(R.id.mtc_cv_teamname)
    var mtc_memo:TextView=textView.findViewById(R.id.mtc_cv_memo)
    var mtc_date:TextView=textView.findViewById(R.id.mtc_cv_date)
    var mtc_time:TextView=textView.findViewById(R.id.mtc_cv_time)
    var mtc_win:TextView=textView.findViewById(R.id.mtc_cv_win)
    var mtc_loss:TextView=textView.findViewById(R.id.mtc_cv_loss)
    var mtc_draw:TextView=textView.findViewById(R.id.mtc_cv_draw)
}

class myteamacceptedchallenges (textView: CardView): RecyclerView.ViewHolder(textView) {
    var mtc_ac_teamname:TextView=textView.findViewById(R.id.mtc_ac_cv_teamname)
    var mtc_ac_memo:TextView=textView.findViewById(R.id.mtc_ac_cv_memo)
    var mtc_ac_date:TextView=textView.findViewById(R.id.mtc_ac_cv_date)
    var mtc_ac_time:TextView=textView.findViewById(R.id.mtc_ac_cv_time)
    var mtc_ac_win:TextView=textView.findViewById(R.id.mtc_ac_cv_win)
    var mtc_ac_loss:TextView=textView.findViewById(R.id.mtc_ac_cv_loss)
    var mtc_ac_draw:TextView=textView.findViewById(R.id.mtc_ac_cv_draw)
}

class myteamcfmt (textView: CardView): RecyclerView.ViewHolder(textView) {
    var mtc_cfmt_teamname:TextView=textView.findViewById(R.id.mtc_cfmt_cv_teamname)
    var mtc_cfmt_memo:TextView=textView.findViewById(R.id.mtc_cfmt_cv_memo)
    var mtc_cfmt_date:TextView=textView.findViewById(R.id.mtc_cfmt_cv_date)
    var mtc_cfmt_time:TextView=textView.findViewById(R.id.mtc_cfmt_cv_time)
    var mtc_cfmt_win:TextView=textView.findViewById(R.id.mtc_cfmt_cv_win)
    var mtc_cfmt_loss:TextView=textView.findViewById(R.id.mtc_cfmt_cv_loss)
    var mtc_cfmt_draw:TextView=textView.findViewById(R.id.mtc_cfmt_cv_draw)
}

class pendinginvitation (textView: CardView): RecyclerView.ViewHolder(textView){
    var pendingemail:TextView=textView.findViewById(R.id.pending_email)
    var editbutton:TextView=textView.findViewById(R.id.pending_editbutton)
    var pendingemailedit:EditText=textView.findViewById(R.id.pendig_email_edit)
}