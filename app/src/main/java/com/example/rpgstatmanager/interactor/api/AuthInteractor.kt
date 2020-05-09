package com.example.rpgstatmanager.interactor.api

import android.util.Log
import com.example.rpgstatmanager.swagger.client.api.TokenApi
import javax.inject.Inject


class AuthInteractor @Inject constructor(private val tokenApi: TokenApi){
    companion object{
        val actualToken : String
            get() = token
        private var token = ""
    }
    fun logIn(name:String,password:String):Boolean{
        val data: String
        val call = tokenApi.getToken(name,password)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()
        return  data.compareTo("") != 0
    }
    fun requestPassword(name:String):Boolean{
        return try {
            tokenApi.getNewPassword(name)
            true
        } catch (e:Exception){
            false
        }
    }
}