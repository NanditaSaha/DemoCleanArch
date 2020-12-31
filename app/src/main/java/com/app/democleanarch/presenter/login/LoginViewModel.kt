package com.app.democleanarch.presenter.login

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.democleanarch.data.model.LoginUser


class LoginViewModel : ViewModel() {
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    private var loginUser = MutableLiveData<LoginUser>()

    fun getUser(): MutableLiveData<LoginUser> {
        return loginUser
    }

    fun onClick(view:View) {
        Log.d("Tag", "click")
        val loginUsers = email.value?.let {
            password.value?.let { it1 ->
                LoginUser(it, it1)
            }
        }
        loginUser.value = loginUsers
    }

}