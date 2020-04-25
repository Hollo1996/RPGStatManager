package com.example.rpgstatmanager.presenter

import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.interactor.data.CharacterInteractor
import com.example.rpgstatmanager.model.Adventure
import com.example.rpgstatmanager.screen.AdventureChooserScreen

object AdventureChooserPresenter : A_Presenter<AdventureChooserScreen>() {
    fun list() = AdventureInteractor.list()
    fun choose(id:String){
        CharacterInteractor.ownerId=id
    }
}