package com.bcit.myminiappxinyangli.data

enum class ApiEndpoints (val url:String){
    BASE_URL("https://www.thecocktaildb.com/api/json/v1/1"),
    SEARCH("${BASE_URL.url}/search.php"),
    FIELDS("${SEARCH.url}?s=")
}