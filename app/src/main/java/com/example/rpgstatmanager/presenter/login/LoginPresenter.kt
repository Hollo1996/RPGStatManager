package com.example.rpgstatmanager.presenter.login

import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.login.LoginScreen
import javax.inject.Inject

class LoginPresenter
@Inject constructor(
        private val authInteractor: AuthInteractor,
        private val adventureInteractor: AdventureInteractor
)
    : A_Presenter<LoginScreen>()  {
    fun validate(name:String,password:String):Boolean{
        if(authInteractor.isValid(name,password)){
            val id = authInteractor.getUserID(name,password)
            adventureInteractor.ownerId=id
            return true
        }
        return false
    }
}