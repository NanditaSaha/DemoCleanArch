package com.app.democleanarch.presenter.login

import android.util.Patterns

object LoginUtil {
    fun validLoginCheck(
        email: String, password: String
    ): Boolean {
        if (email.isEmpty() || password.isEmpty()) {
            return false
        }
        if(password.length<5)
        {
            return false
        }
        return true
    }
}