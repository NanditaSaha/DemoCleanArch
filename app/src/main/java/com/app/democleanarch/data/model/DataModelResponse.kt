package com.app.democleanarch.data.model

import android.util.Patterns


data class LoginUser(val strEmailAddress: String, val strPassword: String) {

    val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(strEmailAddress).matches()

    val isPasswordLengthGreaterThan5: Boolean
        get() = strPassword.length > 5

}