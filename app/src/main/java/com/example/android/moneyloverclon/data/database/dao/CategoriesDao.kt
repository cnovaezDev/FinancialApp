package com.example.android.moneyloverclon.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.android.moneyloverclon.data.database.entities.CategoriesEntity
import com.example.android.moneyloverclon.data.database.entities.TransactionsEntity

/**
 ** Created by Carlos A. Novaez Guerrero on 06/12/2022 14:40
 ** cnovaez.dev@outlook.com
 **/
@Dao
interface CategoriesDao {

    @Insert
    suspend fun insertNewCategory(category: CategoriesEntity)

    @Update
    suspend fun updateExistingCategory(category: CategoriesEntity)

    @Query("Select * from categories where id=:id")
    suspend fun getCategoryById(id: Long): CategoriesEntity?

    @Query("Select * from categories")
    fun getAllCategories(): LiveData<List<CategoriesEntity?>>

    @Query("Select * from categories order by id DESC LIMIT 1")
    suspend fun getLastCreatedCategory(): CategoriesEntity?

    @Query("Delete from categories where id=:id")
    suspend fun deleteCategoryById(id: Long)

    @Query("Delete from categories")
    suspend fun emptyCategoriesTable()
}