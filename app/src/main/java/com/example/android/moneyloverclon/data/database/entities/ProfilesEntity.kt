package com.example.android.moneyloverclon.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:03
 ** cnovaez.dev@outlook.com
 **/
@Entity(tableName = "profiles_entity")
data class ProfilesEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    @ColumnInfo(name = "user")
    var user: String = "John Doe",
    @ColumnInfo(name = "pass")
    var pass: String = "*****"
)
