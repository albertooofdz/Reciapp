package com.example.reciapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reciapp.R
import com.example.reciapp.adapters.RecipeAdapter
import com.example.reciapp.data.RecipeResponse
import com.example.reciapp.data.RecipeServiceApi
import com.example.reciapp.databinding.ActivityListBinding

import com.example.reciapp.utils.Constants.Companion.EXTRA_ID
import com.example.reciapp.utils.Constants.Companion.EXTRA_IMAGE

import com.example.reciapp.utils.RetrofitProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initList()
    }

    private fun initList() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                searchByName(query.orEmpty())
                binding.searchView.clearFocus()

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        adapter= RecipeAdapter{ id, image ->
            navigateToDetail(id, image)
        }
        binding.recycleRecipe.setHasFixedSize(true)
        binding.recycleRecipe.layoutManager = LinearLayoutManager(this)
        binding.recycleRecipe.adapter = adapter
    }

    private fun searchByName(query: String) {

        binding.progressBar.isVisible=true

        val service: RecipeServiceApi = RetrofitProvider.getRetrofit()


        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = service.searchByName(query)
            if (myResponse.isSuccessful){

                val response : RecipeResponse? = myResponse.body()

                if (response!=null){
                Log.i("hola","funciona")
                Log.i("hola",response.toString())
                    runOnUiThread {
                        adapter.updateList(response.recipes)
                        binding.progressBar.isVisible=false
                    }
                }
            } else {
                Log.i("hola","no funciona")
            }

        }
    }
    private fun navigateToDetail(id:Int, image:String){
        val intent= Intent(this, DetailRecipeActivity:: class.java)
        intent.putExtra(EXTRA_ID,id)
        intent.putExtra(EXTRA_IMAGE,image)
        startActivity(intent)

    }
}
