package com.android.pacenow.sharedpreferences

interface ILangPrefHelper {
    fun getCountryCode(): String
    fun setCountryCode(countryCode: String)
}