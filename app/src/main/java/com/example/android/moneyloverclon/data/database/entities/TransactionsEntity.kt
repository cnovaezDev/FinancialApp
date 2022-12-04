package com.example.android.moneyloverclon.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 12:16
 ** cnovaez.dev@outlook.com
 **/
@Entity(tableName = "transactions")
data class TransactionsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "title")
    var title: String = "Empty",
    @ColumnInfo(name = "description")
    var description: String = "No desc",
    @ColumnInfo(name = "quantity")
    var quantity: Double = 0.0,
    @ColumnInfo(name = "date_id")
    var dateId: Long = 0L,
    @ColumnInfo(name = "category_id")
    var categoryId: Long = 0L
)