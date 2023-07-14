package com.dwi.mykoinapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.dwi.mykoinapp.R
import com.dwi.mykoinapp.utils.SharedPreferencesHelper
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()
    private val sharedPreferencesHelper: SharedPreferencesHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = "Text from MainActivity"

        sharedPreferencesHelper.putString("text", text)

        val button = findViewById<Button>(R.id.btn_detail)

        button.setOnClickListener {
            startActivity(Intent(this@MainActivity, DetailActivity::class.java))
        }


        viewModel.getHeadlineNews().observe(this) {
            Log.d("MainActivity", "onCreate: $it")
        }
    }
}