package com.bcit.myminiappxinyangli.ui.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SearchBar(
    value: String?,
    onValueChanged: (String) -> Unit,
    onSearch: () -> Job
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 1.dp
            )
    ) {
        TextField(
            value = value?:"",
            onValueChange = onValueChanged,
            label = { Text("What would you like to drink?") },
            placeholder = { Text("Search drink by name") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                placeholderColor = Color.Gray
                ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .clip(RoundedCornerShape(30.dp)),
            trailingIcon = {
                IconButton(
                    onClick = { onSearch() },
                    modifier = Modifier
                ) {
                    Icon(Icons.Rounded.Search, contentDescription = null)
                }
            }
        )
    }
}