package com.romp.khel.Fragments

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

    lateinit var boom: TextView
    lateinit var boom2: TextView
    lateinit var auth: FirebaseAuth

    lateinit var venuename:EditText
    lateinit var venuelocation:EditText
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
        boom=view.findViewById(R.id.pwo1)
        boom2=view.findViewById(R.id.pwo22)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        boom.text=currentUser?.uid
        boom2.text=currentUser?.email

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
        submit=view.findViewById(R.id.button2)
        val today = Calendar.getInstance()

        datepick.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)) { v, i, i2, i3 ->
            datepickval.text="$i3/$i2/$i"
        }

        timepicker.setOnTimeChangedListener { timePicker, i, i2 ->
            timepickerval.text="$i:$i2"
        }
        endtimepicker.setOnTimeChangedListener { timePicker, i, i2 ->
            endtimepickerval.text="$i:$i2"
        }

        fun createroom(venuname:String, venuloc:String, time1:String, time2:String, date:String, pricepp:String, contact:String, tp:String, jp:String) {
            var totime="$time1-$time2"
            val room=LookingtoPlayRoom(venuname,venuloc,totime,date,pricepp,tp.toInt(),jp.toInt())
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
                    joinedplayers.text.toString().trim()
                )
           // }
        }
    }
}