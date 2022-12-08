package com.example.android.moneyloverclon.utils

/**
 ** Created by Carlos A. Novaez Guerrero on 07/12/2022 7:18
 ** cnovaez.dev@outlook.com
 **/
enum class ResponseState constructor(var msg: String) {
    Success("Transaction successfully"), Pending("Transaction pending"), Fail("Transaction failed");
}