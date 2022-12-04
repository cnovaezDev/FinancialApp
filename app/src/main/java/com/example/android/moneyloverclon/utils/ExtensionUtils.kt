package com.example.android.moneyloverclon.utils

import android.R.string
import android.app.Activity
import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


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

fun Context.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, msg, duration).show()
}
//fun ToBase64(cadena: string?): string? {
//    val textBytes: Unit = System.Text.Encoding.UTF8.GetBytes(cadena)
//    return System.Convert.ToBase64String(textBytes)
//}
//
//fun FromBase64(cadenaCodificada: string?): string? {
//    val base64EncodedBytes: Unit = System.Convert.FromBase64String(base64EncodedData)
//    return System.Text.Encoding.UTF8.GetString(base64EncodedBytes)
//}