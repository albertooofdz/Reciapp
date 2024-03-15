package com.example.reciapp.data

import com.google.gson.annotations.SerializedName

data class RecipeResponse (
    @SerializedName("recipes") val recipes:List<RecipeItemResponse>
)

 data class RecipeItemResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("ingredients") val ingredients:List<String>,
    @SerializedName("prepTimeMinutes") val prepTimeMinutes:Int,
    @SerializedName("cookTimeMinutes") val cookTimeMinutes:Int,
    @SerializedName("difficulty") val difficulty:String,
    @SerializedName("rating") val rating:Float,
    @SerializedName("image") val image:String,


    )