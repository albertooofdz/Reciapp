package com.example.reciapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reciapp.R
import com.example.reciapp.SQLite.RecipeDAO
import com.example.reciapp.adapters.RecipeAdapter
import com.example.reciapp.databinding.ActivityDetailRecipeBinding
import com.example.reciapp.databinding.ActivityFavouriteBinding
import com.squareup.picasso.Picasso

class FavouriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavouriteBinding
    private lateinit var adapter: RecipeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)





    }


}