package com.bcit.myminiappxinyangli.ui.main.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SearchState {
 var searchValue by mutableStateOf("")

    fun onValueChange(value:String) {
        searchValue = value
    }
}