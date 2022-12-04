package com.example.android.moneyloverclon.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.moneyloverclon.utils.castDateToStringDateAndTime
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern
import java.util.*

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 12:22
 ** cnovaez.dev@outlook.com
 **/
@Entity(tableName = "dates")
data class DatesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "date")
    var date: String = castDateToStringDateAndTime(Calendar.getInstance().time)
)