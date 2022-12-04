package com.example.android.moneyloverclon.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:00
 ** cnovaez.dev@outlook.com
 **/
@Entity(tableName = "pending_transactions")
data class PendingTransactionsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "id_transaction")
    var idTransaction: Long = 0L
)
