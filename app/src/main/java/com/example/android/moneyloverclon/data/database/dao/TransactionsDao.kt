package com.example.android.moneyloverclon.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.android.moneyloverclon.data.database.entities.TransactionsEntity

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:12
 ** cnovaez.dev@outlook.com
 **/

@Dao
interface TransactionsDao {

    @Insert
    fun insertTransaction(transactionsEntity: TransactionsEntity)

    @Update
    fun updateTransaction(transactionsEntity: TransactionsEntity)

    @Query("Select * from transactions where id=:id")
    fun getTransactionById(id: Long): TransactionsEntity?

    @Query("Select * from transactions")
    fun getAllTransactions(): List<TransactionsEntity?>

    @Query("Select * from transactions order by id DESC LIMIT 1")
    fun getLastCreatedTransactions(): TransactionsEntity?

    @Query("Delete from transactions where id=:id")
    fun deleteTransactionById(id: Long)

    @Query("Delete from transactions")
    fun emptyTransactionsTable()

}