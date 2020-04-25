package com.example.rpgstatmanager.presenter

import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.model.Adventure
import com.example.rpgstatmanager.screen.AdventureCreatorScreen

object AdventureCreatorPresenter : A_Presenter<AdventureCreatorScreen>() {
    fun save(adventure: Adventure){
        AdventureInteractor.save(adventure)
    }
}