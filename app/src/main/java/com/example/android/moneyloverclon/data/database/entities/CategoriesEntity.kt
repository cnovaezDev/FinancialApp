package com.example.android.moneyloverclon.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.moneyloverclon.utils.CategoryTypes

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 12:39
 ** cnovaez.dev@outlook.com
 **/
@Entity(tableName = "categories")
data class CategoriesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "img_id")
    var imgId: Long = 0L,
    @ColumnInfo(name = "title")
    var title: String = "Empty",
    @ColumnInfo(name = "type")
    var type: CategoryTypes = CategoryTypes.EXPENSE
)
