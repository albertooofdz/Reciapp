package com.example.reciapp.SQLite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context):SQLiteOpenHelper(context,
    "recipes.db",
    null,
    1)
{
    override fun onCreate(db: SQLiteDatabase) {
        val ordenCreate= "CREATE TABLE recipes(" +
                "id INTEGER PRIMARY KEY,"+
                "name TEXT,"+
                "ingredients TEXT,"+
                "prepTimeMinutes INTEGER,"+
                "cookTimeMinutes INTEGER,"+
                "difficulty TEXT,"+
                "rating REAL,"+
                "image TEXT,"+
                "instructions TEXT)"

        db.execSQL(ordenCreate)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val ordenErease= "DROP TABLE IF EXISTS recipes"
        db.execSQL(ordenErease)
        onCreate(db)

    }
}