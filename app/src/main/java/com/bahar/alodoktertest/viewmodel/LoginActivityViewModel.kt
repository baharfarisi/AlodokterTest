package com.bahar.alodoktertest.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.bahar.alodoktertest.util.ValidationUtil

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class LoginActivityViewModel(app: Application) : AndroidViewModel(app) {
    private var validationUtil: ValidationUtil =
        ValidationUtil(app)

    fun validateCredentials(email: String, password: String): LiveData<String> {
        return validationUtil.validateCredentials(email, password)
    }
}