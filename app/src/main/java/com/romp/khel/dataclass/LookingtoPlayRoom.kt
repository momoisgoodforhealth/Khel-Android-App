package com.romp.khel.dataclass

import android.widget.DatePicker
import android.widget.TimePicker

data class LookingtoPlayRoom (
    var futsalname:String?="",
    var location:String?="",
    var time:String?="",
    var date:String?="",
    var pricepp:String?="",
    var playerlimit:Int?=0,
    var playercount:Int?=0
)
