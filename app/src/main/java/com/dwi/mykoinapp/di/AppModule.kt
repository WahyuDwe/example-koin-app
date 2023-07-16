package com.dwi.mykoinapp.di

import android.content.Context
import android.content.SharedPreferences
import com.dwi.mykoinapp.data.api.MyApi
import com.dwi.mykoinapp.data.repo.MainRepositoryImpl
import com.dwi.mykoinapp.ui.MainViewModel
import com.dwi.mykoinapp.utils.SharedPreferencesHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(MyApi::class.java)
    }
    single { provideSharedPreferences(androidContext()) }

    single { SharedPreferencesHelper(get()) }

    single {
        MainRepositoryImpl(get(), get())
    }
    viewModel {
        MainViewModel(get())
    }


}

fun provideSharedPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, Context.MODE_PRIVATE)
}