package com.bahar.alodoktertest.cache

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class SharedPrefManager(context: Context) {
    private lateinit var pref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    init {
        pref = context.getSharedPreferences(SharedPrefKey.prefName, Context.MODE_PRIVATE)
        editor = pref.edit()
    }

    fun setLoginStatus(status: Boolean) {
        editor.putBoolean(SharedPrefKey.loginStatus, status)
        editor.commit()
    }

    fun getLoginStatus(): Boolean {
        return pref.getBoolean(SharedPrefKey.loginStatus, false)
    }
}