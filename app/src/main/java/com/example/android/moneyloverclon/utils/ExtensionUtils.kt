package com.example.android.moneyloverclon.utils

import java.text.SimpleDateFormat
import java.util.Date

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 12:26
 ** cnovaez.dev@outlook.com
 **/
fun castDateToStringDate(date: Date): String {
    val formatter = SimpleDateFormat("dd-MM-yyyy")
    return formatter.format(date)
}
fun castDateToStringDateAndTime(date: Date): String {
    val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm")
    return formatter.format(date)
}