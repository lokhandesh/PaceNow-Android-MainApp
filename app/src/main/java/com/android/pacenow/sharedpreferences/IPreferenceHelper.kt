package com.android.pacenow.sharedpreferences


interface IPreferenceHelper {
    fun setIsLogIn(isLogIn: Boolean)
    fun isLogIn(): Boolean


    fun clearPrefs()
}