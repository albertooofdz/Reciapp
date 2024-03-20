package com.example.reciapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatDelegate
import com.example.reciapp.R
import com.example.reciapp.data.SessionManager
import com.example.reciapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sessionManager= SessionManager(this)
        binding.darkModeSW.setOnCheckedChangeListener{ _ , isSelected ->
            if (isSelected){

                enableDarkMode()

            } else{

                disableDarkMode()

            }

        }
        if(sessionManager.getUserModeState()){
            enableDarkMode()


        }

        else{
            disableDarkMode()
        }
        initView()



    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight()
        sessionManager.setUserModeState(true)
        binding.darkModeSW.isChecked = true


    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        delegate.applyDayNight()
        sessionManager.setUserModeState(false)
        binding.darkModeSW.isChecked = false

    }

    fun initView(){


        binding.allRecipesLL.setOnClickListener{

            val intent = Intent(this@MainActivity, ListActivity::class.java)
            startActivity(intent)




        }

    }


}