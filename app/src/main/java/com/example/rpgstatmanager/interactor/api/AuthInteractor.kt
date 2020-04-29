package com.example.rpgstatmanager.interactor.api

import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val tokenApi: TokenApi){
    companion object{
        val actualToken : String
            get() = token
        private var token = ""
    }
    fun logIn(name:String,password:String):Boolean{
        token = tokenApi.getToken(name,password)
        return  token.compareTo("") != 0
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