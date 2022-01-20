package com.android.pacenow.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.pacenow.base.BaseViewModel
import com.android.pacenow.injection.component.DaggerAppInjector
import com.android.pacenow.model.CountryData
import com.android.pacenow.service.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountryFragmentViewModel : BaseViewModel() {

    @Inject
    lateinit var apiEndPointInterface: ApiInterface
    private var countryResponse = MutableLiveData<CountryData>()
    private var apiErrorResponse = MutableLiveData<Boolean>()
    private  val compositeDisposable = CompositeDisposable()

    init {
        DaggerAppInjector.create().inject(this)
    }

    fun getCountryResponse() : MutableLiveData<CountryData> {
        return countryResponse
    }

    fun getCountryApiErrorResponse() : MutableLiveData<Boolean> {
        return apiErrorResponse
    }

    fun getCountryList() {
       var disposable = apiEndPointInterface.getCountryList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<CountryData>(){
                override fun onSuccess(t: CountryData) {
                    countryResponse.value = t
                    apiErrorResponse.value= false
                }

                override fun onError(e: Throwable) {
                    apiErrorResponse.value = true
                }

            })
        compositeDisposable.add(disposable)

    }



}