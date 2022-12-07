package com.example.android.moneyloverclon.ui.viewModels.add_transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.moneyloverclon.data.database.dao.CategoriesDao
/**
 ** Created by Carlos A. Novaez Guerrero on 06/12/2022 14:14
 ** cnovaez.dev@outlook.com
 **/
class AddTransactionViewModelFactory(
    private val categoryId: Long,
    private val database: CategoriesDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddTransactionViewModel::class.java)) {
            return AddTransactionViewModel(database,categoryId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}