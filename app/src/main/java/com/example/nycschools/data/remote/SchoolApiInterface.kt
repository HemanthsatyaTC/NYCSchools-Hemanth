package com.example.nycschools.data.remote

import com.example.nycschools.data.model.SchoolDataItemModel
import retrofit2.http.GET

interface SchoolApiInterface {
    @GET(SchoolApiDetails.END_POINTS)
    suspend fun getDetails(): List<SchoolDataItemModel>
}