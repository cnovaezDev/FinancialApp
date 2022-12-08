package com.example.android.moneyloverclon.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.android.moneyloverclon.R
import com.example.android.moneyloverclon.databinding.ActivityMainBinding
import com.example.android.moneyloverclon.ui.fragments.NoDataFragmentDirections
import com.example.android.moneyloverclon.utils.navigate
import com.example.android.moneyloverclon.utils.showToast
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var mbottomNavigationView: NavigationBarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        addCustomItemAdd()
        mbottomNavigationView.setOnItemSelectedListener(this)
        setContentView(binding.root)
    }

    /**
     * Boiler plate code for adding a custom item to the BottomNavigationView
     */
    @SuppressLint("RestrictedApi")
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


    //TODO Study if there is a better way to do this onItemClickListener - done
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //In order for this to function the id of the item must be the same that he one from the fragment
        return NavigationUI.
        onNavDestinationSelected(item,this.findNavController(R.id.navHost)) || super.onOptionsItemSelected(item)

//        when(item.itemId){
//            R.id.wallet_option -> this.showToast("wallet")
//            R.id.charts_option -> this?.showToast("chart")
//            R.id.add_option -> navigate(NoDataFragmentDirections.actionNoDataFragmentToAddTransactionFragment())
//            //R.id.add_option -> navigate(NoDataFragmentDirections.actionNoDataFragmentToAddTransactionFragment(), option_view)
//            R.id.planing_option -> this?.showToast("plan")
//            R.id.profile_option -> this?.showToast("profile")
//        }
//        return true;
    }

}