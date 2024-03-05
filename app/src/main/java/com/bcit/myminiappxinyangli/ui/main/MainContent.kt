package com.bcit.myminiappxinyangli.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bcit.myminiappxinyangli.data.Drink
import com.bcit.myminiappxinyangli.ui.main.state.DrinkState
import com.bcit.myminiappxinyangli.ui.main.state.SearchState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(drinkState: DrinkState) {

    val scope = CoroutineScope(context = Dispatchers.Main)
    val searchState = remember { SearchState() }

    val getImage = { drink: Drink ->
        drinkState.getImageUrl(drink.image)
    }

    val onSearch = {
        scope.launch {
            val searchJob = launch { drinkState.getDrink(searchState.searchValue ?: "") }
            searchJob.start()
            searchJob.join()
        }
    }

    Scaffold(
        topBar = {
            SearchBar(
                value = searchState.searchValue,
                onValueChanged = searchState::onValueChange,
                onSearch = onSearch
            )
        }
    ) { it ->
        if(drinkState.drinkList.value.drinks?.isNotEmpty() == true) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .background(Color(0xFFFFFFFF)),
                content = {
                    items(drinkState.drinkList.value.drinks!!.size) {
                        DrinkItem(drink = drinkState.drinkList.value.drinks!![it], getImage = getImage)
                    }
                }
            )
        }
    }
}
