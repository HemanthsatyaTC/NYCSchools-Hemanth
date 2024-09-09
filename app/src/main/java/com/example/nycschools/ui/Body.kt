package com.example.nycschools.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Horizontal
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Body(
    modifier: Modifier = Modifier
){
    Box(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .heightIn(min = 106.dp)
        .background(Color.Cyan)
    ){
        Column {
            Text(text = "Find what best works for you!",
            modifier = Modifier.padding(10.dp)
            )
            Text(text = "Explore categories",
                modifier = Modifier.padding(10.dp))

        }

    }


}