package com.example.android.moneyloverclon.ui.viewModels.add_transaction

import android.content.res.Resources
import androidx.lifecycle.*
import com.example.android.moneyloverclon.R
import com.example.android.moneyloverclon.data.database.dao.CategoriesDao
import com.example.android.moneyloverclon.data.database.dao.TransactionsDao
import com.example.android.moneyloverclon.utils.CategoryTypes
import com.example.android.moneyloverclon.utils.ResourcesProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 06/12/2022 14:14
 ** cnovaez.dev@outlook.com
 **/
// We are using @AssistedInject instead
// of normal @Inject as we want
// to assist one dependency by our own
// at runtime and rest by dagger-hilt
class AddTransactionViewModel @AssistedInject constructor(
    private val transactionsDao: TransactionsDao,
    private val categoriesDao: CategoriesDao,
    private val resourcesProvider: ResourcesProvider,
    // dependency which is to be assisted by
    // us should be annotated with @Assisted
    @Assisted
    private val categoryId: Long = 0L
) :
    ViewModel() {

     var navigateToEnterAmountScreen: MutableLiveData<Boolean> = MutableLiveData<Boolean>()



    // It's a factory of this viewmodel, we need
    // to annotate this factory interface
    // with @AssistedFactory in order to
    // let Dagger-Hilt know about it
    @AssistedFactory
    interface AddTransactionViewModelFactory {
        fun create(categoryId: Long): AddTransactionViewModel
    }

    // Suppressing unchecked cast warning
    @Suppress("UNCHECKED_CAST")
    companion object {
        // putting this function inside
        // companion object so that we can
        // access it from outside i.e. from fragment/activity
        fun providesFactory(
            assistedFactory: AddTransactionViewModelFactory,
            categoryId: Long
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                // using our ArticlesFeedViewModelFactory's create function
                // to actually create our viewmodel instance
                return assistedFactory.create(categoryId) as T
            }
        }
    }

    private var _textColor = MutableLiveData<Int>()

    val textColor: LiveData<Int>
        get() = _textColor

    // var _categoryId = MutableLiveData<Long>()

    init {
        if (categoryId != 0L) {
            getCategoryType()
        } else {
            changeTextColor(CategoryTypes.INCOME, )
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
            CategoryTypes.INCOME -> resourcesProvider.getColor(R.color.green_color)
            CategoryTypes.EXPENSE -> resourcesProvider.getColor(R.color.red_color)
        }

    }

    fun navigateToEnterAmountScreen(){
        navigateToEnterAmountScreen.value = true
        endNavigationToAmountScreen()
    }
    private fun endNavigationToAmountScreen(){
        navigateToEnterAmountScreen.value = false

    }

}