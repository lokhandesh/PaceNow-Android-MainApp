package com.android.pacenow.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.pacenow.sharedpreferences.ILangPrefHelper
import com.android.pacenow.sharedpreferences.IPreferenceHelper
import com.android.pacenow.sharedpreferences.LangPrefManager
import com.android.pacenow.sharedpreferences.PreferenceManager

open class BaseActivity : AppCompatActivity() {

    val langPrefHelper: ILangPrefHelper by lazy { LangPrefManager(this) }
    val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}