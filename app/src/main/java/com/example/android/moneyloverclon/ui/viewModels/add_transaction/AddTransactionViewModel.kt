package com.example.android.moneyloverclon.ui.viewModels.add_transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.moneyloverclon.R
import com.example.android.moneyloverclon.data.database.dao.CategoriesDao
import com.example.android.moneyloverclon.utils.CategoryTypes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 06/12/2022 14:14
 ** cnovaez.dev@outlook.com
 **/

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val categoriesDao: CategoriesDao,
    private val categoryId: Long = 0L
) :
    ViewModel() {

    private var _textColor = MutableLiveData<Int>()
    val textColor: LiveData<Int>
        get() = _textColor

   // var _categoryId = MutableLiveData<Long>()

    init {
        if (categoryId != 0L) {
            getCategoryType()
        } else {
            changeTextColor(CategoryTypes.INCOME)
        }
    }


    private fun getCategoryType() {
        viewModelScope.launch {
            val category = categoriesDao.getCategoryById(categoryId)
            category?.let {
                changeTextColor(it.type)
            }
        }
    }

    private fun changeTextColor(type: CategoryTypes) {
        _textColor.value = when (type) {
            CategoryTypes.EXPENSE -> R.color.green_color
            CategoryTypes.INCOME -> R.color.red_color
        }

    }


}