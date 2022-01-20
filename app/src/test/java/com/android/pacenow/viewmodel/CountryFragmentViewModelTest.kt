package com.android.pacenow.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.pacenow.model.CountryData
import com.android.pacenow.service.ApiInterface
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

@RunWith(JUnit4::class)
class CountryFragmentViewModelTest : TestCase() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @InjectMocks
    var countryFragmentViewModel = CountryFragmentViewModel()

    private var singleResponse : Single<CountryData>? = null

    public override fun setUp() {
        // super.setUp()
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun testErrorResponse() {

        singleResponse = Single.error(Throwable())
        Mockito.`when`(Mockito.mock(ApiInterface::class.java).getCountryList()).thenReturn(singleResponse)
        countryFragmentViewModel.getCountryList()

        Assert.assertEquals(false,countryFragmentViewModel.getCountryApiErrorResponse().value)

    }

    @Test
    fun testRetriveProductList() {

        val list: MutableList<CountryData.Country.AvailableRegion> = mutableListOf()

        val country = CountryData.Country(list,
                                            "Andorra","Andorra","AD","AND","AD")

        val data = CountryData(mutableListOf(country))

        singleResponse = Single.just(data)
        Mockito.`when`(Mockito.mock(ApiInterface::class.java).getCountryList()).thenReturn(singleResponse)
        countryFragmentViewModel.getCountryList()

        Assert.assertEquals(249,countryFragmentViewModel.getCountryResponse().value?.country?.size)


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