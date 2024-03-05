package com.bcit.myminiappxinyangli

import android.app.Application
import com.bcit.myminiappxinyangli.data.DrinkRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

class MyApp : Application() {
    private val client by lazy {
        HttpClient() {
            install(ContentNegotiation) {
                gson()
            }
        }
    }

    val drinkRepository by lazy {
        DrinkRepository(client)
    }
}