package com.example.rpgstatmanager.presenter

import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.interactor.data.CharacterInteractor
import com.example.rpgstatmanager.model.D_Character
import com.example.rpgstatmanager.screen.AdventureChooserScreen
import javax.inject.Inject

class AdventureChooserPresenter
@Inject constructor(
    private val adventureInteractor: AdventureInteractor,
    private val characterInteractor: CharacterInteractor
)
    : A_Presenter<AdventureChooserScreen>() {
    fun list() = adventureInteractor.list()
    fun choose(id:String){
        val temp=adventureInteractor.getWhen { it.id == id }
        PathTracker.adventure.id=temp.id
        PathTracker.adventure.icon=temp.icon
        PathTracker.adventure.name=temp.name
        PathTracker.adventure.isGm=temp.is_gm
    }
}