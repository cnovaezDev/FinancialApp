package com.example.android.moneyloverclon.ui.fragments.add_transactions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.android.moneyloverclon.data.database.FinancialDatabase
import com.example.android.moneyloverclon.databinding.FragmentAddTransactionBinding
import com.example.android.moneyloverclon.ui.viewModels.add_transaction.AddTransactionViewModel
import com.example.android.moneyloverclon.ui.viewModels.add_transaction.AddTransactionViewModelFactory

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:20
 ** cnovaez.dev@outlook.com
 **/
class AddTransactionFragment : Fragment() {
    private lateinit var _binding: FragmentAddTransactionBinding
    private val binding: FragmentAddTransactionBinding get() = _binding

    private lateinit var addTransactionViewModel: AddTransactionViewModel
    private lateinit var viewModelFactory: AddTransactionViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * Boiler plate code for creating a new instance of a viewModel with parameters
         * and using viewModelFactory
         */
        val application = requireNotNull(this.activity).application

        viewModelFactory =
            AddTransactionViewModelFactory(
                //Capture the argument on the fragment
                AddTransactionFragmentArgs.fromBundle(requireArguments()).categoryId,
                //Get a instance of the database and then return the desired DAO
                FinancialDatabase.getInstance(
                    application
                ).categoriesDao
            )

        //Create the viewmodel using the ViewModelProvider and passing the viewmodelfactory as a parameter
        addTransactionViewModel =
            ViewModelProvider(this, viewModelFactory).get(AddTransactionViewModel::class.java)
        /**
         * end of the boiler plate code
         */
        _binding.addTransactionViewModel = addTransactionViewModel
        _binding.lifecycleOwner = this
    }


}