package com.bcit.myminiappxinyangli.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.bcit.myminiappxinyangli.data.Drink
import kotlin.reflect.full.memberProperties

@Composable
fun DrinkDetails(drink: Drink) {
    val showIngredients = { drink: Drink ->
        val ingredientList = mutableListOf<String>()
        for (prop in Drink::class.memberProperties) {
            // Check if the property is an ingredient
            if (prop.name.startsWith("strIngredient")) {
                // Get the ingredient number from the property name
                val ingredientNumber = prop.name.removePrefix("strIngredient").toIntOrNull()

                // If it's a valid ingredient number, get the corresponding measure property
                if (ingredientNumber != null) {
                    val measureProp = Drink::class.memberProperties
                        .find { it.name == "strMeasure$ingredientNumber" }

                    // Get the ingredient and measure values
                    val ingredient = prop.get(drink) as? String

                    var measure = measureProp?.get(drink) as? String

                    // If both ingredient and measure are not null, add to the list
                    if (ingredient != null && measure != null) {
                        measure = measure.trim()
                        ingredientList.add("$measure $ingredient")
                    }
                }
            }
        }
        ingredientList
    }
    val legendTextStyle = TextStyle(fontWeight = FontWeight.Bold)
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
    ) {
        LabeledText("Category: ", drink.category, legendTextStyle)
        LabeledText("Alcoholic: ", drink.alcoholic, legendTextStyle)
        LabeledText("Glass: ", drink.glass, legendTextStyle)
        LabeledText("Ingredients:\n", showIngredients(drink).joinToString(), legendTextStyle)
        LabeledText("Instructions:\n", drink.instructions, legendTextStyle)
    }
}

@Composable
fun LabeledText(label: String, value: String, style: TextStyle, modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(label)
            }
            append(value)
        },
        modifier = modifier.padding(10.dp, 5.dp)
    )
}
