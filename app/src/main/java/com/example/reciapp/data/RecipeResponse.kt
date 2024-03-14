package com.example.reciapp.data

import com.google.gson.annotations.SerializedName

data class RecipeResponse (
    @SerializedName("recipes") val recipes:List<RecipeItemResponse>
)

 data class RecipeItemResponse (
    @SerializedName("ingredients") val ingredients:String,
    @SerializedName("prepTimeMinutes") val prepTimeMinutes:Int,
    @SerializedName("cookTimeMinutes") val cookTimeMinutes:Int,
    @SerializedName("difficulty") val difficulty:Float,
    @SerializedName("rating") val rating:String,
    @SerializedName("image") val image:String,


    )