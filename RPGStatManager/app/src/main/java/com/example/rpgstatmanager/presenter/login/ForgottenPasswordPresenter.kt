package com.example.rpgstatmanager.presenter.login

import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.login.ForgottenPasswordScreen

object ForgottenPasswordPresenter : A_Presenter<ForgottenPasswordScreen>()  {
    fun sendReset(name:String):Boolean{
        if(AuthInteractor.isValid(name)){
            AuthInteractor.sendPasswordReset(name)
            return true
        }
        return false
    }
}
