package com.example.android.moneyloverclon.domain.use_cases.transactions

import android.util.Log
import com.example.android.moneyloverclon.data.database.entities.TransactionsEntity
import com.example.android.moneyloverclon.data.repositories.TransactionsRepository
import com.example.android.moneyloverclon.utils.ResponseState
import com.example.android.moneyloverclon.utils.getFailResponse
import com.example.android.moneyloverclon.utils.logError
import timber.log.Timber
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 07/12/2022 7:16
 ** cnovaez.dev@outlook.com
 **/
class InsertNewTransactionUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository
) {

    suspend fun invoke(transaction: TransactionsEntity): ResponseState {
        var state = ResponseState.Pending
        try {
            transactionsRepository.insertNewTransaction(transaction)
            state = ResponseState.Success
        } catch (ex: Exception) {
            logError("In  InsertNewtransactionUseCase  ${ex.message.toString()}")
            state = getFailResponse(ex.message.toString())
        }
        return state
    }
}