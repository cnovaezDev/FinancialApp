package com.example.android.moneyloverclon.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.moneyloverclon.data.database.dao.CategoriesDao
import com.example.android.moneyloverclon.data.database.dao.TransactionsDao
import com.example.android.moneyloverclon.data.database.entities.*

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:20
 ** cnovaez.dev@outlook.com
 **/
@Database(
    version = 1,
    exportSchema = true,
    entities = [TransactionsEntity::class, CategoriesEntity::class, DatesEntity::class, PendingTransactionsEntity::class, ProfilesEntity::class]
)
abstract class FinancialDatabase : RoomDatabase() {

    abstract fun getTransactionsDao(): TransactionsDao
    abstract fun getCategoriesDao(): CategoriesDao

//    /**
//     * Boiler plate code for creating a new instance of the database
//     */
//    companion object {
//        @Volatile
//        private var INSTANCE: FinancialDatabase? = null
//
//        fun getInstance(context: Context): FinancialDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        FinancialDatabase::class.java,
//                        "financial_database"
//                    ).fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
}
