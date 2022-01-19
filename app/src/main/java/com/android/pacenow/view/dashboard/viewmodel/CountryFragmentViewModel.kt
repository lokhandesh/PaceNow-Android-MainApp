package com.android.pacenow.view.dashboard.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.pacenow.injection.component.DaggerAppInjector
import com.android.pacenow.model.CountryResponse
import com.android.pacenow.service.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountryFragmentViewModel : ViewModel() {

    @Inject
    lateinit var apiEndPointInterface: ApiInterface
    private var countryResponse = MutableLiveData<CountryResponse>()
    private var apiErrorResponse = MutableLiveData<Boolean>()

    init {
        DaggerAppInjector.create().inject(this)
    }

    fun getCountryResponse() : MutableLiveData<CountryResponse> {
        return countryResponse
    }

    fun getCountryApiErrorResponse() : MutableLiveData<Boolean> {
        return apiErrorResponse
    }

    fun getCountryList() {
        apiEndPointInterface.getCountryList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<CountryResponse>(){
                override fun onSuccess(t: CountryResponse) {
                    countryResponse.value = t
                }

                override fun onError(e: Throwable) {
                    apiErrorResponse.value = false
                }

            })
    }



}