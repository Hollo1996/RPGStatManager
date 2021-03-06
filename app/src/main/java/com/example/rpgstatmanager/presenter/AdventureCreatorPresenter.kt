package com.example.rpgstatmanager.presenter

import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.model.D_Adventure
import com.example.rpgstatmanager.screen.AdventureCreatorScreen
import javax.inject.Inject

class AdventureCreatorPresenter
@Inject constructor(private val adventureInteractor: AdventureInteractor)
    : A_Presenter<AdventureCreatorScreen>() {
    fun save(DAdventure: D_Adventure){
        adventureInteractor.save(DAdventure,false)
    }
}