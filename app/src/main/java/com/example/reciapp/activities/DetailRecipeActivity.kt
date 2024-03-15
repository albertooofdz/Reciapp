package com.example.reciapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reciapp.R
import com.example.reciapp.utils.Constants.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recipe)
        val id=intent.getIntExtra (EXTRA_ID, -1)
        getRecipeInfo(id)
    }

    private fun getRecipeInfo(id: Int) {


        }

    }





