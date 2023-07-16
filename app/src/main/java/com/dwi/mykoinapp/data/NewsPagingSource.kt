package com.dwi.mykoinapp.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dwi.mykoinapp.data.api.MyApi
import com.dwi.mykoinapp.data.model.ArticlesItem


class NewsPagingSource(private val myApi: MyApi) : PagingSource<Int, ArticlesItem>() {

    override fun getRefreshKey(state: PagingState<Int, ArticlesItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticlesItem> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val responseData = myApi.getHeadLine(position, params.loadSize).articles?.toList() ?: emptyList()

            LoadResult.Page(
                data = responseData,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (responseData.isNullOrEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            Log.e("NewsPagingSource", "load: ${e.message}", e)
            return LoadResult.Error(e)
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }
}