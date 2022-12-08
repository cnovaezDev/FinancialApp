package com.example.android.moneyloverclon.domain.use_cases.transactions

import com.example.android.moneyloverclon.data.database.entities.TransactionsEntity
import com.example.android.moneyloverclon.data.repositories.TransactionsRepository
import com.example.android.moneyloverclon.utils.ResponseState
import com.example.android.moneyloverclon.utils.getFailResponse
import com.example.android.moneyloverclon.utils.logError
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 07/12/2022 8:19
 ** cnovaez.dev@outlook.com
 **/
class UpdateTransactionUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository
) {

    suspend fun invoke(transactionsEntity: TransactionsEntity): ResponseState {
        var state = ResponseState.Pending
        state = try {
            transactionsRepository.updateTransaction(transactionsEntity)
            ResponseState.Success
        } catch (ex: Exception) {
            logError(ex.message.toString())
            getFailResponse(ex.message.toString())
        }
        return state
    }
}