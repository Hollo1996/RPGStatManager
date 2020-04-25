package com.example.rpgstatmanager.presenter.login

import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.login.ForgottenPasswordScreen
import javax.inject.Inject

class ForgottenPasswordPresenter
@Inject constructor(private val authInteractor: AuthInteractor)
    : A_Presenter<ForgottenPasswordScreen>()  {
    fun sendReset(name:String):Boolean{
        if(authInteractor.isValid(name)){
            authInteractor.sendPasswordReset(name)
            return true
        }
        return false
    }
}
