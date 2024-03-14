package com.example.reciapp.data

import com.google.gson.annotations.SerializedName

data class RecipeResponse (
    @SerializedName("recipes") val recipes:List<Recipe>
)

class Recipe (
    @SerializedName("ingredients") val ingredients:List<String>,
    @SerializedName("prepTimeMinutes") val prepTimeMinutes:Int,
    @SerializedName("cookTimeMinutes") val cookTimeMinutes:Int,
    @SerializedName("difficulty") val difficulty:Float,
    @SerializedName("rating") val rating:List<String>,
    @SerializedName("image") val image:List<String>,





)