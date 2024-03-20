package com.example.reciapp.data

import android.content.Context
import android.content.SharedPreferences

class SessionManager (context: Context){
    private var prefs:SharedPreferences=
        context.getSharedPreferences("night_mode", Context.MODE_PRIVATE)
        companion object{
        const val USER_MODE_STATE="user_mode_state"}

    fun setUserModeState(isChanged:Boolean){
        val editor=prefs.edit()
        editor.putBoolean(USER_MODE_STATE,isChanged)
        editor.apply()
    }
    fun getUserModeState():Boolean{
        return prefs.getBoolean(USER_MODE_STATE,false)
    }
}