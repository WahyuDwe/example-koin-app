package com.dwi.mykoinapp.utils

import android.content.SharedPreferences

class SharedPreferencesHelper(private val sharedPreferences: SharedPreferences) {

    private fun edit(): SharedPreferences.Editor {
        return sharedPreferences.edit()
    }

    fun putString(key: String, value: String?) = edit().putString(key, value).apply()

    fun getString(key: String) = sharedPreferences.getString(key, null)

}