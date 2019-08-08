package com.bahar.alodoktertest.repository

import android.arch.lifecycle.MutableLiveData
import com.bahar.alodoktertest.R
import com.bahar.alodoktertest.model.UserModel

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class UserRepository {
    // repository data that you can get from webservices or sql

    private var instance: UserRepository? = null
    private var dataSet: UserModel = UserModel()

    public fun getInstance(): UserRepository {
        if (instance == null) {
            instance = UserRepository()
        }
        return instance as UserRepository
    }

    public fun getUserData(): MutableLiveData<UserModel> {
        setUserData()

        val data: MutableLiveData<UserModel> = MutableLiveData()
        data.value = dataSet

        return data
    }

    private fun setUserData() {
        dataSet = UserModel()
        dataSet.name = "Bacharudin A.R.F"
        dataSet.phone = "+6281225122676"
        dataSet.gender = "Male"
    }
}