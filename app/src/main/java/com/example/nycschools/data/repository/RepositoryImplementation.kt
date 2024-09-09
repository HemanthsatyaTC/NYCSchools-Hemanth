package com.example.nycschools.data.repository

import com.example.nycschools.data.model.SchoolDataItemModel
import com.example.nycschools.data.remote.SchoolApiInterface
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    val apiSchool : SchoolApiInterface
): Repository  {
    override suspend fun getDetails(): List<SchoolDataItemModel> {
        return apiSchool.getDetails()
    }

}