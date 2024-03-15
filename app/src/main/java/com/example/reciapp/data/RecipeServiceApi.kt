package com.example.reciapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeServiceApi {
    @GET("search")
    suspend fun searchByName(@Query("q") recipeName:String) : Response<RecipeResponse>
    @GET("{id}")
    suspend fun searchById(@Path("id")recipeId:Int) : Response<RecipeResponse>

}