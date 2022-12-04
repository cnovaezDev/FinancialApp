package com.example.android.moneyloverclon.utils

/**
 ** Created by Carlos A. Novaez Guerrero on 04/12/2022 12:43
 ** cnovaez.dev@outlook.com
 **/
enum class CategoryTypes {
    EXPENSE,
    INCOME;

    override fun toString(): String {
        return when (this) {
            EXPENSE -> "Expense"
            INCOME -> "Income"
        }
    }
}