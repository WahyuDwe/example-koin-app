package com.dwi.mykoinapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dwi.mykoinapp.R
import com.dwi.mykoinapp.utils.SharedPreferencesHelper
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity() {
    private val sharedPreferencesHelper: SharedPreferencesHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Log.d("DetailActivity", "Preferences text: ${sharedPreferencesHelper.getString("text")}")
    }
}