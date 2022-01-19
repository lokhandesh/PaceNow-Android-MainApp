package com.android.pacenow.service

import com.android.pacenow.model.CountryResponse
import io.reactivex.Single
import retrofit2.http.GET


interface ApiInterface {


    @GET("countries")
    fun getCountryList(): Single<CountryResponse>




}