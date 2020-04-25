package com.example.rpgstatmanager.presenter.login

import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.AdventureChooserScreen
import com.example.rpgstatmanager.screen.login.LoginScreen
import com.example.rpgstatmanager.view.login.LoginActivity

object LoginPresenter : A_Presenter<LoginScreen>()  {
    fun validate(name:String,password:String):Boolean{
        if(AuthInteractor.isValid(name,password)){
            val id = AuthInteractor.getUserID(name,password)
            AdventureInteractor.ownerId=id
            return true
        }
        return false
    }
}