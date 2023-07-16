package com.dwi.mykoinapp.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.dwi.mykoinapp.data.NewsPagingSource
import com.dwi.mykoinapp.data.api.MyApi
import com.dwi.mykoinapp.data.model.ArticlesItem
import com.dwi.mykoinapp.data.model.HeadlineResponse
import com.dwi.mykoinapp.utils.SharedPreferencesHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepositoryImpl(
    private val api: MyApi,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : MainRepository {

    override fun getHeadline(): LiveData<PagingData<ArticlesItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                NewsPagingSource(api)
            }
        ).liveData
    }
}