package com.dwi.mykoinapp.di

import com.dwi.mykoinapp.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

//    viewModel {
//        MainViewModel(get())
//    }

    viewModelOf(::MainViewModel)
}