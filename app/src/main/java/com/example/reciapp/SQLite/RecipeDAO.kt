package com.example.reciapp.SQLite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.reciapp.activities.ListActivity
import com.example.reciapp.data.RecipeItemResponse
import com.example.reciapp.data.RecipeResponse

class RecipeDAO (context: Context){
    private var databaseManager: DatabaseHelper = DatabaseHelper(context)

    fun insert(recipe: RecipeItemResponse) {
        val db = databaseManager.writableDatabase

        var values = ContentValues()

        values.put("id", recipe.id)
        values.put("name",recipe.name)
        values.put("ingredients",recipe.ingredients.joinToString { it })
        values.put("prepTimeMinutes",recipe.prepTimeMinutes)
        values.put("cookTimeMinutes",recipe.cookTimeMinutes)
        values.put("difficulty",recipe.difficulty)
        values.put("rating",recipe.rating)
        values.put("image",recipe.image)
        values.put("instructions",recipe.instructions.joinToString { it })


        var insertedId = db.insert("recipes", null, values)
        Log.i("DATABASE", "Inserted ID: $insertedId")

        db.close()

    }

    fun update(recipe: RecipeItemResponse) {
        val db = databaseManager.writableDatabase

        var values = ContentValues()

        values.put("id", recipe.id)
        values.put("name",recipe.name)
        values.put("ingredients",recipe.ingredients.joinToString { it })
        values.put("prepTimeMinutes",recipe.prepTimeMinutes)
        values.put("cookTimeMinutes",recipe.cookTimeMinutes)
        values.put("difficulty",recipe.difficulty)
        values.put("rating",recipe.rating)
        values.put("image",recipe.image)
        values.put("instructions",recipe.instructions.joinToString { it })

        var updatedRows = db.update("recipes", values, "id =${recipe.id}", null)
        Log.i("DATABASE", "Updated records: $updatedRows")

        db.close()
    }

    fun delete(recipe: RecipeItemResponse) {
        val db = databaseManager.writableDatabase
        //db.execSQL("DELETE FROM Task WHERE id = 1")

        val deletedRows = db.delete("recipes", "id = ${recipe.id}", null)
        Log.i("DATABASE", "Deleted rows: $deletedRows")

        db.close()

    }
    fun deleteAll() {
        val db = databaseManager.writableDatabase
        //db.execSQL("DELETE FROM Task WHERE id = 1")

        val deletedRows = db.delete("recipes", null, null)
        Log.i("DATABASE", "Deleted rows: $deletedRows")

        db.close()

    }
    @SuppressLint("Range")
    fun find(id:Int): RecipeItemResponse? {


        val db = databaseManager.readableDatabase

        val cursor = db.query(
            "recipes",                 // The table to query
            null,     // The array of columns to return (pass null to get all)
            "id=$id",                // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )

        var recipe:RecipeItemResponse? = null


        if (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val ingredients=cursor.getString(cursor.getColumnIndex("ingredients")).split(", ")
            val prepTimeMinutes = cursor.getInt(cursor.getColumnIndex("prepTimeMinutes"))
            val cookTimeMinutes = cursor.getInt(cursor.getColumnIndex("cookTimeMinutes"))
            val difficulty = cursor.getString(cursor.getColumnIndex("difficulty"))
            val rating = cursor.getFloat(cursor.getColumnIndex("rating"))
            val image = cursor.getString(cursor.getColumnIndex("image"))
            val instructions = cursor.getString(cursor.getColumnIndex("instructions")).split(", ")
            Log.i("DATABASE", "$id -> $name")



           recipe=RecipeItemResponse(id,name,ingredients,prepTimeMinutes,cookTimeMinutes,difficulty,rating,image,instructions)
        }
        cursor.close()
        db.close()

        return recipe


    }
    @SuppressLint("Range")
    fun findAll(): List<RecipeItemResponse> {

        val db = databaseManager.readableDatabase

        val cursor = db.query(
           "recipes",                 // The table to query
            null,    // The array of columns to return (pass null to get all)
            null,                // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )

        var list: MutableList<RecipeItemResponse> = mutableListOf()


        while (cursor.moveToNext()) {
                val id = cursor.getInt(cursor.getColumnIndex("id"))
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val ingredients=cursor.getString(cursor.getColumnIndex("ingredients")).split(", ")
                val prepTimeMinutes = cursor.getInt(cursor.getColumnIndex("prepTimeMinutes"))
                val cookTimeMinutes = cursor.getInt(cursor.getColumnIndex("cookTimeMinutes"))
                val difficulty = cursor.getString(cursor.getColumnIndex("difficulty"))
                val rating = cursor.getFloat(cursor.getColumnIndex("rating"))
                val image = cursor.getString(cursor.getColumnIndex("image"))
                val instructions = cursor.getString(cursor.getColumnIndex("instructions")).split(", ")
                  Log.i("DATABASE", "$id -> $name")

            val recipe=RecipeItemResponse(id,name,ingredients,prepTimeMinutes,cookTimeMinutes,difficulty,rating,image,instructions)

            list.add(recipe)

        }

        cursor.close()
        db.close()

        return list
    }

}