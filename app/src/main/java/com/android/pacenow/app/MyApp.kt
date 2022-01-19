package com.android.pacenow.app

import android.app.Application
import com.android.pacenow.injection.component.AppInjector
import com.android.pacenow.injection.component.DaggerAppInjector
import com.android.pacenow.injection.module.NetworkModule

class MyApp : Application() {

    private lateinit var appComponent: AppInjector

    override fun onCreate() {
        super.onCreate()
        myAppInstance = this

        initDaggerAppComponent()

    }

    companion object {
        private var myAppInstance: MyApp? = null
        fun  getInstance(): MyApp? {
            if (myAppInstance == null) {
                myAppInstance = MyApp()
            }
            return myAppInstance
        }

    }

     private fun initDaggerAppComponent() {
         appComponent = DaggerAppInjector.builder()
             .networkModule(NetworkModule())
             .build()
     }

    fun getDaggerComponent() : AppInjector {
        return appComponent
    }


}