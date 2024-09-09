package com.example.nycschools.data.repository

import com.example.nycschools.data.model.SchoolDataItemModel

interface Repository {
    suspend fun getDetails(): List<SchoolDataItemModel>
}