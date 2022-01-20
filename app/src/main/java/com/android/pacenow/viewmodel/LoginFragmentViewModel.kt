package com.android.pacenow.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginFragmentViewModel : ViewModel() {


    private var errorResponse = MutableLiveData<Boolean>()
    private var successResponse = MutableLiveData<Boolean>()

    fun errorResponse() : MutableLiveData<Boolean> {
        return errorResponse
    }

    fun successResponse() : MutableLiveData<Boolean> {
        return successResponse
    }


    fun validateUser(userName : String, password :String) {
        if (userName.isEmpty() || password.isEmpty()) {
            errorResponse.value = true
        } else if (userName != "pacenow" || password != "pacenow") {
            errorResponse.value = true
        } else {
            successResponse.value = true
        }
    }


}