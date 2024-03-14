package com.example.reciapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeServiceApi {
    @GET("/search?q={name}")
    suspend fun searchByName(@Query("name") recipeName:String) : Response<RecipeResponse>
}