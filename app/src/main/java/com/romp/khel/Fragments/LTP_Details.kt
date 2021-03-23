
package com.romp.khel.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.romp.khel.*
import kotlinx.android.synthetic.main.fragment_l_t_p__details.view.*

class LTP_Details : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_l_t_p__details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val venue:TextView=view.findViewById(R.id.ltpdetails_venuename)
        val location:TextView=view.findViewById(R.id.ltpdetails_location)
        val date:TextView=view.findViewById(R.id.ltpdetails_date)
        val time:TextView=view.findViewById(R.id.ltpdetails_time)
        val price:TextView=view.findViewById(R.id.ltpdetails_price)
        val pcount:TextView=view.findViewById(R.id.ltpdetails_playercount)
        val plimit:TextView=view.findViewById(R.id.ltpdetails_playerlimit)
        val contact:TextView=view.findViewById(R.id.ltpdetails_othercontact)
        val phone:TextView=view.findViewById(R.id.ltpdetails_contact)
        val addinfo:TextView=view.findViewById(R.id.ltpdetails_addinfo)
        val whatsapp:Button=view.findViewById(R.id.whatsappbutton)
        val call:Button=view.findViewById(R.id.callbutton)

        venue.text= ltpfutsalname
        location.text= ltplocation
        date.text= ltpdate
        time.text= ltptime
        price.text= ltppricepp
        pcount.text= ltpplayercount.toString()
        plimit.text= ltpplayerlimit.toString()
        phone.text= ltpphone
        contact.text= ltpcontact.toString()
        addinfo.text= ltpaddinfo
        whatsapp.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=+977${phone.text}&text=Hello! I saw your Room listing in Khel for ${venue.text}. I am interested and would like to inquire further.")
            startActivity(intent)
        }
        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL);
            intent.data = Uri.parse("tel:${phone.text}")
            startActivity(intent)
        }

    }
}