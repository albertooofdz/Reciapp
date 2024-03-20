package com.example.reciapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.reciapp.R
import com.example.reciapp.SQLite.RecipeDAO
import com.example.reciapp.data.RecipeItemResponse

import com.example.reciapp.data.RecipeServiceApi
import com.example.reciapp.databinding.ActivityDetailRecipeBinding
import com.example.reciapp.utils.Constants.Companion.EXTRA_ID
import com.example.reciapp.utils.Constants.Companion.EXTRA_IMAGE
import com.example.reciapp.utils.RetrofitProvider
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailRecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRecipeBinding
    lateinit var recipeDAO: RecipeDAO
    lateinit var recipe : RecipeItemResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recipeDAO = RecipeDAO(this)
        val image=intent.getStringExtra(EXTRA_IMAGE)
        val id=intent.getIntExtra (EXTRA_ID, -1)


        Picasso.get().load(image).into(binding.detailImageIV)



        getRecipeInfo(id)
    }

    private fun getRecipeInfo(id: Int) {

        val service: RecipeServiceApi = RetrofitProvider.getRetrofit()


        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = service.searchById(id)
            if (myResponse.isSuccessful){
                val response : RecipeItemResponse? = myResponse.body()

                if (response!=null){
                    Log.i("hola","funciona")
                    Log.i("hola",response.toString())
                    runOnUiThread {
                        recipe=response
                        loadData()

                    }
                }
            }
        }
    }
    private fun loadData(){

        var instructionsText=""
        recipe.instructions.forEachIndexed { index, element ->
            if (index>0) instructionsText +="\n"
            instructionsText+= "- $element"}

        binding.instructionTV.text=instructionsText

        var ingredientsText=""
        recipe.ingredients.forEachIndexed { index, element ->
            if(index>0) ingredientsText += "\n"
            ingredientsText+= "- $element"}
        binding.ingredientsTV.text= ingredientsText

        binding.detailPrepTimeTV.text= (recipe.prepTimeMinutes+recipe.cookTimeMinutes).toString()+"'"

        binding.detailRatingTV.text=recipe.rating.toString()

        binding.detailDifficultTV.text=recipe.difficulty





    }

}





