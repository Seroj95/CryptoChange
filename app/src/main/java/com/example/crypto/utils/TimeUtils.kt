package com.example.crypto.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun convertTimestampToTime(timestamp:Long?):String{
    if (timestamp==null)return ""

    val stamp=Timestamp(timestamp*1000)
    val date=Date(stamp.time)
    val patern="HH:mm:ss"
    val sdf=SimpleDateFormat(patern,Locale.getDefault())
    sdf.timeZone= TimeZone.getDefault()
    return sdf.format(date)
}