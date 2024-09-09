package com.example.nycschools.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nycschools.ui.screen.SchoolViewModel
import com.example.nycschools.data.model.SchoolDataItemModel

@Composable
fun SchoolDetailsScreen(
    //    function: () -> Unit,
    viewModel: SchoolViewModel = hiltViewModel()

) {
    val schoolData by viewModel.schoolData

    if (schoolData.isEmpty()) {
        // Show loading message or animation
        Text(text = "Loading...")
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(schoolData) { school ->
                SchoolDataItem(school = school)
            }
        }
    }
}

@Composable
fun SchoolDataItem(
    school: SchoolDataItemModel
//    function: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            school.schoolName?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h6
                )
            }
            Text(
                text = "Address: ${school.location}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Contact: ${school.phoneNumber}",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "City: ${school.city}",
                style = MaterialTheme.typography.body2
            )
            Button(onClick = {
//                function.invoke()

            },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                modifier = Modifier.padding(10.dp)
                .align(Alignment.CenterHorizontally)) {
                Text(text = "View More Details")
            }
        }
    }
}
