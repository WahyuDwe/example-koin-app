package com.dwi.mykoinapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dwi.mykoinapp.data.model.ArticlesItem
import com.dwi.mykoinapp.data.repo.MainRepository
import com.dwi.mykoinapp.data.repo.MainRepositoryImpl

class MainViewModel(private val mMainRepository: MainRepositoryImpl): ViewModel() {
    val headline: LiveData<PagingData<ArticlesItem>> =
        mMainRepository.getHeadline().cachedIn(viewModelScope)

}