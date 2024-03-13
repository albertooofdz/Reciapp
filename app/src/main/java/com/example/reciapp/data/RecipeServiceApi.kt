package com.example.reciapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeServiceApi {
    @GET("/{name}")
    suspend fun searchByName(@Path("name") query:String) : Response<RecipeResponse>
}