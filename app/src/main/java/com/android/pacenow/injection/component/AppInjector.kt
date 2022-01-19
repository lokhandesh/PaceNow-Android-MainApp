package com.android.pacenow.injection.component

import com.android.pacenow.injection.module.NetworkModule
import com.android.pacenow.view.dashboard.viewmodel.CountryFragmentViewModel
import com.android.pacenow.view.viewmodel.LoginFragmentViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface AppInjector {
    fun inject(loginFragmentViewModel: LoginFragmentViewModel)
    fun inject(countryFragmentViewModel: CountryFragmentViewModel)
}