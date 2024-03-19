package com.example.reciapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.reciapp.R
import com.example.reciapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    fun initView(){
        binding.allRecipesLL.setOnClickListener{

            val intent = Intent(this@MainActivity, ListActivity::class.java)
            startActivity(intent)

        binding.favRecipesLL.setOnClickListener{

            val intent = Intent(this@MainActivity, FavouriteActivity::class.java)
            startActivity(intent)
        }
        }

    }


}