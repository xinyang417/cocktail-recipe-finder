package com.bcit.myminiappxinyangli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bcit.myminiappxinyangli.ui.main.state.DrinkState
import com.bcit.myminiappxinyangli.ui.main.MainContent

/**
 * Xinyang Li
 * A01302443
 *
 * This app allows user to search for drinks (mostly alcoholic) by name and
 * click on a dink to view info. User can enter words like "vodka", "tequila",
 * or letters in the search bar and click the search icon, then a list of
 * drinks containing that word/letters will display. Have fun!
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val drinkRepository = (application as MyApp).drinkRepository
        setContent {
            val drinkState = DrinkState(drinkRepository)
            MainContent(drinkState = drinkState)
        }
    }
}
