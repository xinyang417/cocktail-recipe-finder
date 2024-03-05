package com.bcit.myminiappxinyangli.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class DrinkRepository(private val client: HttpClient) {

    suspend fun getDrink(searchValue: String) : Drinks {
        val response = client.get("${ApiEndpoints.FIELDS.url}$searchValue")
        val json = response.body<JsonObject>().toString()
        return deserializeJson(json)
    }

    private fun deserializeJson(json:String) : Drinks {
        return Gson().fromJson(json, Drinks::class.java)
    }

    fun getImageUrl(url: String): String {
        return url
    }
}