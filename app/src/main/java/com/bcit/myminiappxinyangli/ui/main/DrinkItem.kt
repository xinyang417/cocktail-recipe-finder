package com.bcit.myminiappxinyangli.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bcit.myminiappxinyangli.data.Drink

@Composable
fun DrinkItem(drink: Drink, getImage: (Drink) -> String) {
    var showDetails by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(10.dp, 30.dp)
            .fillMaxSize()
            .background(if (showDetails) Color(0xFFD0F4F8) else Color.White)
            .clickable { showDetails = !showDetails },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = if (showDetails) {
                Modifier
                    .size(150.dp)
                    .padding(10.dp)
                    .clip(CircleShape)
            } else {
                Modifier
                    .size(250.dp)
                    .clip(CircleShape)
            },
            model = getImage(drink),
            contentDescription = null
        )

        Text(
            drink.name,
            style = if (showDetails) {
                TextStyle(
                    fontSize = 20.sp,
                    color = Color(0xFF000000),
                    fontFamily = FontFamily.Serif
                )
            } else {
                TextStyle(
                    fontSize = 25.sp,
                    color = Color(0xFF000000),
                    fontFamily = FontFamily.Serif
                )
            }
        )
        if (showDetails) {
            DrinkDetails(drink = drink)
        }
    }
}
