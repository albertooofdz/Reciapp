package com.example.reciapp.utils

import com.example.reciapp.data.RecipeServiceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {
    companion object {
        fun getRetrofit(): RecipeServiceApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RecipeServiceApi::class.java)
        }
    }
}