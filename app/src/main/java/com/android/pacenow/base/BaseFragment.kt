package com.android.pacenow.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.pacenow.sharedpreferences.ILangPrefHelper
import com.android.pacenow.sharedpreferences.IPreferenceHelper
import com.android.pacenow.sharedpreferences.LangPrefManager
import com.android.pacenow.sharedpreferences.PreferenceManager

open class BaseFragment : Fragment() {

    val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(requireContext()) }
    val langPrefHelper: ILangPrefHelper by lazy { LangPrefManager(requireContext()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}