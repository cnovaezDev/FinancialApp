package com.example.android.moneyloverclon.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.moneyloverclon.R
import com.example.android.moneyloverclon.databinding.FragmentNoDataBinding

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 13:20
 ** cnovaez.dev@outlook.com
 **/
class NoDataFragment : Fragment() {

    private lateinit var _binding: FragmentNoDataBinding
    private val binding: FragmentNoDataBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoDataBinding.inflate(inflater, container, false)
        return binding.root
    }


}