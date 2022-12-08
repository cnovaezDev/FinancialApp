package com.example.android.moneyloverclon.utils

import android.R.string
import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.android.moneyloverclon.R
import timber.log.Timber
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

fun Context.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

/**
 * Prints a log of the error using Timber
 */
fun logError(msg: String) {
    Timber.tag("Error").e(msg)
}

/**
 * Prints a log of the information using Timber
 */
fun logInformation(msg: String) {
    Timber.tag("Information").i(msg)
}

/**
 * Returns a personalized ResponseState Fail message with the details of the error
 * @param msg: String: The msg of the error
 * @return ResponseState.Fail with the msg passed as param
 */
fun getFailResponse(msg: String): ResponseState {
    var state = ResponseState.Fail
    state.msg = msg;
    return state

}

fun Activity.navigate(navDirections: NavDirections){
    this.findNavController(R.id.navHost).navigate(navDirections)
}
fun navigate(navDirections: NavDirections, v: View){
    v.findNavController().navigate(navDirections)
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