package com.dwi.mykoinapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dwi.mykoinapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val text = "Text from MainActivity"
//        sharedPreferencesHelper.putString("text", text)
        binding.rvNews.layoutManager = LinearLayoutManager(this)

        newsAdapter = NewsAdapter()
        binding.rvNews.adapter = newsAdapter
        viewModel.headline.observe(this) { headline ->
            newsAdapter.submitData(lifecycle, headline)
            Log.d("MainActivity", "headline: $headline")
        }
    }
}