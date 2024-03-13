package com.example.reciapp.data

import com.google.gson.annotations.SerializedName

class RecipeResponse (
    @SerializedName("response") val response:String,
    @SerializedName("results-for") val resultsFor:String,
    @SerializedName("results") val results:List<Recipe>
)

class Recipe (
    @SerializedName("ingredients") val ingredients:List<String>,
    @SerializedName("prepTimeMinutes") val prepTimeMinutes:Int,
    @SerializedName("cookTimeMinutes") val cookTimeMinutes:Int,
    @SerializedName("difficulty") val difficulty:Float,
    @SerializedName("rating") val rating:List<String>,
    @SerializedName("image") val image:List<String>,





)