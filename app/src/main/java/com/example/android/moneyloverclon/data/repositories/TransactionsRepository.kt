package com.example.android.moneyloverclon.data.repositories

import com.example.android.moneyloverclon.data.database.dao.TransactionsDao
import com.example.android.moneyloverclon.data.database.entities.TransactionsEntity
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 07/12/2022 7:04
 ** cnovaez.dev@outlook.com
 **/
class TransactionsRepository @Inject constructor(
    private val transactionsDao: TransactionsDao
) {

    suspend fun insertNewTransaction(transaction: TransactionsEntity) =
        transactionsDao.insertTransaction(transaction)

    suspend fun updateTransaction(transaction: TransactionsEntity) =
        transactionsDao.updateTransaction(transaction)

    suspend fun getTransactionById(id: Long) = transactionsDao.getTransactionById(id)

    suspend fun getLastCreatedTransaction() = transactionsDao.getLastCreatedTransactions()

    suspend fun deleteTransactionById(id: Long) = transactionsDao.deleteTransactionById(id)

    suspend fun deleteAllTransactionsOnTheTable() = transactionsDao.emptyTransactionsTable()
}