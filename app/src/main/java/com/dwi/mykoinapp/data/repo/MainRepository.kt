package com.dwi.mykoinapp.data.repo

import androidx.lifecycle.LiveData
import com.dwi.mykoinapp.data.model.HeadlineResponse

interface MainRepository {
    fun getHeadline(): LiveData<HeadlineResponse>
}