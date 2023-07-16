package com.dwi.mykoinapp.data.repo

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.PagingData
import com.dwi.mykoinapp.data.model.ArticlesItem
import com.dwi.mykoinapp.data.model.HeadlineResponse

interface MainRepository {
    fun getHeadline(): LiveData<PagingData<ArticlesItem>>
}