package com.example.android.moneyloverclon.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.moneyloverclon.R
import com.example.android.moneyloverclon.databinding.FragmentEnterAmountBinding

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:20
 ** cnovaez.dev@outlook.com
 **/
class EnterAmountFragment : Fragment() {

    private lateinit var _binding: FragmentEnterAmountBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEnterAmountBinding.inflate(inflater, container, false)
        return _binding.root
    }

}