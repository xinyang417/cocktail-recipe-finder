package com.bcit.myminiappxinyangli.ui.main.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.bcit.myminiappxinyangli.data.DrinkRepository
import com.bcit.myminiappxinyangli.data.Drinks

class DrinkState(private val drinkRepository: DrinkRepository) {
    val drinkList: MutableState<Drinks> = mutableStateOf(Drinks(emptyList()))

    suspend fun getDrink(searchValue: String) {
        drinkList.value = drinkRepository.getDrink(searchValue)
    }

    fun getImageUrl(url:String):String {
        return drinkRepository.getImageUrl(url)
    }
}