package com.android.pacenow.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

@RunWith(JUnit4::class)
class LoginFragmentViewModelTest : TestCase(){

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    var loginFragmentViewModel = LoginFragmentViewModel()


    @Test
    fun testSuccessfulLogin() {
        Mockito.`when`(Mockito.mock(loginFragmentViewModel::class.java).validateUser("pace","pace")).thenReturn(true)
        loginFragmentViewModel.validateUser("pace","pace")
        Assert.assertEquals(true,loginFragmentViewModel.successResponse().value)
    }
    @Test
    fun testUnSuccessfulLogin() {
        Mockito.`when`(Mockito.mock(loginFragmentViewModel::class.java).validateUser("paceno","paceno")).thenReturn(false)
        loginFragmentViewModel.validateUser("paceno","paceno")
        Assert.assertEquals(true,loginFragmentViewModel.errorResponse().value)
    }

    @Before
    fun setUpRxSchedulers(){
        val immidiate = object: Scheduler() {
            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
            }
            override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
                return super.scheduleDirect(run, 0, unit)
            }

        }
        RxJavaPlugins.setInitIoSchedulerHandler{ scheduler: Callable<Scheduler>? -> immidiate }
        RxJavaPlugins.setInitComputationSchedulerHandler { scheduler: Callable<Scheduler>? -> immidiate }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler: Callable<Scheduler>? ->  immidiate}
        RxJavaPlugins.setInitSingleSchedulerHandler { scheduler: Callable<Scheduler>? -> immidiate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler>? -> immidiate }



    }

}