package com.bahar.alodoktertest.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bahar.alodoktertest.model.UserModel
import com.bahar.alodoktertest.repository.UserRepository

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class UserDetailsFragmentViewModel : ViewModel() {

    private var userDetails: MutableLiveData<UserModel>? = MutableLiveData()
    private lateinit var userRepo: UserRepository

    fun init() {
        userRepo = UserRepository().getInstance()
        userDetails = userRepo.getUserData()
    }

    fun getUserDetails(): LiveData<UserModel> {
        return userDetails!!
    }
}