package com.android.pacenow.service

import com.android.pacenow.model.CountryData
import io.reactivex.Single
import retrofit2.http.GET


interface ApiInterface {


    @GET("countryList.json")
    fun getCountryList(): Single<CountryData>




}