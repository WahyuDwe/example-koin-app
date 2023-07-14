package com.dwi.mykoinapp.ui

import androidx.lifecycle.ViewModel
import com.dwi.mykoinapp.data.repo.MainRepository
import com.dwi.mykoinapp.data.repo.MainRepositoryImpl

class MainViewModel(private val mMainRepository: MainRepositoryImpl): ViewModel() {
    fun getHeadlineNews() = mMainRepository.getHeadline()

}