package com.example.android.moneyloverclon.data.di

import android.content.Context
import androidx.room.Room
import com.example.android.moneyloverclon.data.database.FinancialDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 ** Created by Carlos A. Novaez Guerrero on 06/12/2022 20:09
 ** cnovaez.dev@outlook.com
 **/
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val  DATABASE_NAME = "financial_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FinancialDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideTransactionsDao(db: FinancialDatabase) = db.getTransactionsDao()

    @Singleton
    @Provides
    fun provideCategoriesDao(db: FinancialDatabase) = db.getCategoriesDao()
}