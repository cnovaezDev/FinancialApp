package com.example.android.moneyloverclon.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.android.moneyloverclon.R
import com.example.android.moneyloverclon.databinding.FragmentOptionsBinding
import com.example.android.moneyloverclon.ui.viewModels.OptionsViewModel
import com.example.android.moneyloverclon.utils.showToast
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:20
 ** cnovaez.dev@outlook.com
 **/
class OptionsFragment : Fragment(), NavigationBarView.OnItemSelectedListener {

    private lateinit var _binding: FragmentOptionsBinding
    private val binding: FragmentOptionsBinding get() = _binding

    private lateinit var mbottomNavigationView: NavigationBarView

    private val optionsViewModel: OptionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addCustomItemAdd()
        mbottomNavigationView.setOnItemSelectedListener(this)
    }

    /**
     * Boiler plate code for adding a custom item to the BottomNavigationView
     */
    private fun addCustomItemAdd() {
        mbottomNavigationView = binding.bottomNavigationMenu
        val mbottomNavigationMenuView =
            mbottomNavigationView.getChildAt(0) as BottomNavigationMenuView
        val view = mbottomNavigationMenuView.getChildAt(2)
        val itemView = view as BottomNavigationItemView
        val add: View = LayoutInflater.from(view.context)
            .inflate(
                R.layout.custom_layout_add_transaction,
                mbottomNavigationMenuView, false
            )

        itemView.addView(add)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.wallet_option -> context?.showToast("wallet")
           R.id.charts_option -> context?.showToast("chart")
           R.id.add_option -> context?.showToast("add")
           R.id.planing_option -> context?.showToast("plan")
           R.id.profile_option -> context?.showToast("profile")
       }
        return true;
    }


}
