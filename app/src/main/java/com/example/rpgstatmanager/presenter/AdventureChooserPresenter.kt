package com.example.rpgstatmanager.presenter

import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.interactor.data.CharacterInteractor
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
        characterInteractor.ownerId=id
    }
}