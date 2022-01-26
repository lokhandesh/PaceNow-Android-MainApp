package com.android.pacenow.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.pacenow.base.BaseViewModel
import kotlinx.coroutines.async

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

    private fun coroutineCall() {
        viewModelScope.async {  }
    }

}