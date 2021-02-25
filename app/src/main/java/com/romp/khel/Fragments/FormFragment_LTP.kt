package com.romp.khel.Fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.romp.khel.R
import com.romp.khel.dataclass.LookingtoPlayRoom
import java.util.*

class FormFragment_LTP : Fragment() {
    var database = FirebaseDatabase.getInstance().getReference()
    lateinit var auth: FirebaseAuth

    lateinit var selectvenuebutton:Button
    lateinit var venuename:TextView
    lateinit var venuelocation:TextView
    lateinit var timepicker:TimePicker
    lateinit var timepickerval:TextView
    lateinit var endtimepicker:TimePicker
    lateinit var endtimepickerval:TextView
    lateinit var datepick:DatePicker
    lateinit var datepickval:TextView
    lateinit var contacttext:EditText
    lateinit var totalplayers:EditText
    lateinit var joinedplayers:EditText
    lateinit var pricepp:EditText
    lateinit var addinfo:EditText
    lateinit var submit:Button

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_ltp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser

        selectvenuebutton=view.findViewById(R.id.ltpform_selectvenuebutton)
        venuename=view.findViewById(R.id.ltpform_editvenue)
        venuelocation=view.findViewById(R.id.ltpform_editlocation)
        timepicker=view.findViewById(R.id.ltpform_timepicker)
        timepickerval=view.findViewById(R.id.ltpform_edittime)
        endtimepicker=view.findViewById(R.id.ltpform_endtimepicker)
        endtimepickerval=view.findViewById(R.id.ltpform_editendtime)
        datepick=view.findViewById(R.id.ltpform_datepicker)
        datepickval=view.findViewById(R.id.ltpform_editdate)
        contacttext=view.findViewById(R.id.ltpform_editcontact)
        totalplayers=view.findViewById(R.id.ltpform_edittotalplayers)
        joinedplayers=view.findViewById(R.id.ltpform_editjoinedplayers)
        pricepp=view.findViewById(R.id.ltpform_editpricepp)
        addinfo=view.findViewById(R.id.ltpform_editaddinfo)
        submit=view.findViewById(R.id.button2)
        val today = Calendar.getInstance()


        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Select Venue")
        val day = arrayOf("Kick Futsal Lalitpur","Shankhamul Futsal", "Royal Futsal","Shantinagar Futsal", "Prismatic Futsal and Recreation Center", "Dhobighat Futsal", "Maa Banglamukhi Futsal")
        builder.setItems(day) { dialog, which ->
            when (which) {
                0 -> {venuename.text="Kick Futsal Lalitpur" ; venuelocation.text="Bangalamukhi-Sankhamul Road"}
                1 -> {venuename.text="Shankhamul Futsal" ; venuelocation.text="Sankhamul Marga"}
                2 -> {venuename.text="Royal Futsal" ; venuelocation.text="Psuhpa Nagar Marg Marga"}
                3 -> {venuename.text="Shantinagar Futsal" ; venuelocation.text="Thulo Kharibot Marga"}
                4 -> {venuename.text="Prismatic Futsal and Recreation Center" ; venuelocation.text="Milap Road"}
                5 -> {venuename.text="Dhobighat Futsal" ; venuelocation.text="Jhamsikhel Marg"}
                6 -> {venuename.text="Maa Banglamukhi Futsal"; venuelocation.text="Chakupat" }
            }
        }
        selectvenuebutton.setOnClickListener {
            val dialog = builder.create()
            dialog.show()
        }

        datepick.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)) { v, i, i2, i3 ->
            var ii3=i3.toString()
            var ie2=i2+1
            var ii2=ie2.toString()
            if (i3<10) { ii3="0"+i3 }
            if (i2<10) { ii2="0"+ie2}
            datepickval.text="$ii3/$ii2/$i"
        }

        timepicker.setOnTimeChangedListener { timePicker, i, i2 ->
            timepickerval.text="$i:$i2"
        }
        endtimepicker.setOnTimeChangedListener { timePicker, i, i2 ->
            endtimepickerval.text="$i:$i2"
        }

        fun createroom(venuname:String, venuloc:String, time1:String, time2:String, date:String, pricepp:String, contact:String, tp:String, jp:String, uid:String, adinfo:String) {
            var totime="$time1-$time2"
            val room=LookingtoPlayRoom(venuname,venuloc,totime,date,pricepp,tp.toInt(),jp.toInt(),contact,uid, adinfo)
            database.child("lookingtoplay").push().setValue(room)
                .addOnSuccessListener {
                    Navigation.findNavController(view).navigate(R.id.action_formFragment_LTP_to_tournamentSuccess)
                }
                .addOnFailureListener {
                    Toast.makeText(activity,"ERROR: $it", Toast.LENGTH_LONG).show()
                }
        }

        submit.setOnClickListener {
         /*   if (venuename.text.toString().trim().isNotBlank() || venuelocation.text.toString().trim().isNotBlank() || timepickerval.text.toString().trim().isNotBlank() || endtimepickerval.text.toString().trim().isNotBlank() ||
                    datepickval.text.toString().trim().isNotBlank() || contacttext.text.toString().trim().isNotBlank() || totalplayers.text.toString().trim().isNotBlank() ||
                    joinedplayers.text.toString().trim().isNotBlank() || pricepp.text.toString().trim().isNotBlank()) {
                        var vn=venuename.text.toString().trim() ; var vl=venuelocation.text.toString().trim() ; var tpv=timepickerval.text.toString().trim() ; var etpv=endtimepickerval.text.toString().trim()
                        var dpv=datepickval.text.toString().trim(); var ct=contacttext.text.toString().trim() ; var jp=joinedplayers.text.toString().trim() ; var pp=pricepp.text.toString().trim()
                        var tt=totalplayers.text.toString().trim()
                Toast.makeText(activity, "$vn ! $vl ! $tpv ! $etpv ! $dpv ! $ct ! $tt ! $jp ! $pp", Toast.LENGTH_LONG).show()
            } else {  */
                createroom(
                    venuename.text.toString().trim(),
                    venuelocation.text.toString().trim(),
                    timepickerval.text.toString().trim(),
                    endtimepickerval.text.toString().trim(),
                    datepickval.text.toString(),
                    pricepp.text.toString().trim(),
                    contacttext.text.toString().trim(),
                    totalplayers.text.toString().trim(),
                    joinedplayers.text.toString().trim(),
                    currentUser?.uid.toString(),
                    addinfo.text.toString()
                )
           // }
        }
    }
}