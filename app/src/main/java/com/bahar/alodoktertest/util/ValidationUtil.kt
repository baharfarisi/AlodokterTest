package com.bahar.alodoktertest.util

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import java.util.regex.Pattern

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class ValidationUtil(app: Application) {
    var application: Application = app

    fun validateCredentials(email: String, password: String): LiveData<String> {
        val loginMessage = MutableLiveData<String>()
        if (isEmailValid(email)) {
            if (password.length > 12 && !isValidPassword(password)) {
                loginMessage.value = "Password Invalid"
            } else if (password.length < 4) {
                loginMessage.value = "Password is between 4-12 character"
            } else {
                loginMessage.value = "Login Successful"
            }
        } else if (email.isEmpty()) {
            loginMessage.value = "Email Cannot Be Empty"
        } else {
            loginMessage.value = "Invalid Email"
        }

        return loginMessage
    }

    private fun isValidPassword(password: String): Boolean {
        val expression = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#\$%^&+=!])(?=\\\\S+\$).{4,}\$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }

    private fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)

        return matcher.matches()
    }
}