package com.android.pacenow.service

import com.android.pacenow.model.CountryResponse
import io.reactivex.Single


interface ApiInterface {


    fun getCountryList(): Single<CountryResponse>




}