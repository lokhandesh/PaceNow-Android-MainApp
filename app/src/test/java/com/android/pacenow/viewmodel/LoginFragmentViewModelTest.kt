package com.android.pacenow.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.pacenow.model.CountryData
import io.reactivex.Single
import junit.framework.TestCase
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito

@RunWith(JUnit4::class)
class LoginFragmentViewModelTest : TestCase(){

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    var loginFragmentViewModel = LoginFragmentViewModel()

    private var singleResponse : Single<CountryData>? = null

    public override fun setUp() {
        // super.setUp()
        loginFragmentViewModel = Mockito.mock(loginFragmentViewModel::class.java)
    }

    @Test
    fun testSuccessfulLogin() {

    }
    @Test
    fun testUnSuccessfulLogin() {

    }


}