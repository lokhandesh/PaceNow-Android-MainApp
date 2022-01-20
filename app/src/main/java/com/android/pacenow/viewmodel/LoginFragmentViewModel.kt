package com.android.pacenow.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.pacenow.base.BaseViewModel

class LoginFragmentViewModel : BaseViewModel() {


    private var errorResponse = MutableLiveData<Boolean>()
    private var successResponse = MutableLiveData<Boolean>()

    fun errorResponse() : MutableLiveData<Boolean> {
        return errorResponse
    }

    fun successResponse() : MutableLiveData<Boolean> {
        return successResponse
    }


    fun validateUser(userName : String, password :String) : Boolean {
        if (userName.isEmpty() || password.isEmpty()) {
            errorResponse.value = true
        } else if (userName != "pace" || password != "pace") {
            errorResponse.value = true
        } else {
            successResponse.value = true
            return true
        }
        return false
    }


}