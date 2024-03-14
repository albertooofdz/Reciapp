package com.example.reciapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.reciapp.R
import com.example.reciapp.data.RecipeServiceApi
import com.example.reciapp.databinding.ActivityListBinding
import com.example.reciapp.utils.RetrofitProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class ListActivity : AppCompatActivity() {

    private lateinit var binding:ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initList()
    }

    private fun initList(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {

                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean { return false }
        })
    }
    private fun searchByName(query:String){

        val service: RecipeServiceApi = RetrofitProvider.getRetrofit()


        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = service.searchByName(query)
        }


    }
}
