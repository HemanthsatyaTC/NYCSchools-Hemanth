package com.example.nycschools.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.data.model.SchoolDataItemModel
import com.example.nycschools.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _schoolData = mutableStateOf<List<SchoolDataItemModel>>(emptyList())
    val schoolData: State<List<SchoolDataItemModel>> = _schoolData

    init {
        fetchSchoolDetails()
    }

    private fun fetchSchoolDetails() {
        viewModelScope.launch {
            try {
                val details = repository.getDetails()
                _schoolData.value = details
            } catch (e: Exception) {
                // Handle exceptions
            }
        }
    }
}