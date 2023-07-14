package com.dwi.mykoinapp.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dwi.mykoinapp.data.api.MyApi
import com.dwi.mykoinapp.data.model.HeadlineResponse
import com.dwi.mykoinapp.utils.SharedPreferencesHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepositoryImpl(
    private val api: MyApi,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : MainRepository {

    override fun getHeadline(): LiveData<HeadlineResponse> {
        val headlineResult: MutableLiveData<HeadlineResponse> = MutableLiveData()

        api.getHeadLine().enqueue(object : Callback<HeadlineResponse> {
            override fun onResponse(
                call: Call<HeadlineResponse>,
                response: Response<HeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    headlineResult.value = response.body()
                    Log.d("HeadLine result", "onResponse --> ${response.body()}")
                }
            }

            override fun onFailure(call: Call<HeadlineResponse>, t: Throwable) {
                headlineResult.value = null
                Log.e("HeadLine Result", "onFailure --> ${t.message}")
            }
        })
        return headlineResult
    }
}