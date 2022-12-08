package com.example.android.moneyloverclon.ui.fragments.add_transactions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.android.moneyloverclon.data.database.FinancialDatabase
import com.example.android.moneyloverclon.databinding.FragmentAddTransactionBinding
import com.example.android.moneyloverclon.ui.viewModels.add_transaction.AddTransactionViewModel
import com.example.android.moneyloverclon.utils.navigate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:20
 ** cnovaez.dev@outlook.com
 **/
@AndroidEntryPoint
class AddTransactionFragment : Fragment() {
    private lateinit var _binding: FragmentAddTransactionBinding
    private val binding: FragmentAddTransactionBinding get() = _binding


    // Using navargs for getting argument
    // supplied from previous fragment
    private val args: AddTransactionFragmentArgs by navArgs()

    // First injecting our
    // viewmodel's factory interface
    @Inject
    lateinit var addTransactionViewModelFactory: AddTransactionViewModel.AddTransactionViewModelFactory


    private val addTransactionViewModel: AddTransactionViewModel by viewModels {
        AddTransactionViewModel.providesFactory(
            assistedFactory = addTransactionViewModelFactory,
            categoryId = args.categoryId
        )
    }
//    private lateinit var viewModelFactory: AddTransactionViewModelFactory

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
        //  CreateViewModelWithViewModelFactory()

        _binding.addTransactionViewModel = addTransactionViewModel
        _binding.lifecycleOwner = this

        addTransactionViewModel.navigateToEnterAmountScreen.observe(viewLifecycleOwner) { value ->
            if (value) {
                navigate(AddTransactionFragmentDirections.actionAddTransactionFragmentToEnterAmountFragment(), view)
            }
        }

    }

    private fun CreateViewModelWithViewModelFactory() {
        /**
         * Boiler plate code for creating a new instance of a viewModel with parameters
         * and using viewModelFactory
         */
        //   val application = requireNotNull(this.activity).application

        //        viewModelFactory =
        //            AddTransactionViewModelFactory(
        //                //Capture the argument on the fragment
        //                AddTransactionFragmentArgs.fromBundle(requireArguments()).categoryId,
        //                //Get a instance of the database and then return the desired DAO
        //                FinancialDatabase.getInstance(
        //                    application
        //                ).categoriesDao
        //            )


        //Create the viewmodel using the ViewModelProvider and passing the viewmodelfactory as a parameter
        //        addTransactionViewModel =
        //            ViewModelProvider(this, viewModelFactory).get(AddTransactionViewModel::class.java)
        /**
         * end of the boiler plate code
         */
    }


}