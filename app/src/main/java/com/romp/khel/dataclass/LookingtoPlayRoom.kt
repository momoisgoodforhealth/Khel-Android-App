package com.romp.khel.dataclass

import java.text.SimpleDateFormat

data class LookingtoPlayRoom (
    var futsalname:String?="",
    var location:String?="",
    var time:SimpleDateFormat?,
    var date:SimpleDateFormat?,
    var pricepp:String?="",
    var playerlimit:Int?=0,
    var playercount:Int?=0
)
