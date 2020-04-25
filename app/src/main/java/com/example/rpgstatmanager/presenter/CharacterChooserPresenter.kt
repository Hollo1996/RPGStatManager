package com.example.rpgstatmanager.presenter

import com.example.rpgstatmanager.interactor.data.CharacterInteractor
import com.example.rpgstatmanager.interactor.data.character.*
import com.example.rpgstatmanager.screen.CharacterChooserScreen

object CharacterChooserPresenter : A_Presenter<CharacterChooserScreen>()  {
    fun list() = CharacterInteractor.list()
    fun choose(id:String){
        AbilityInteractor.ownerId=id
        EmotionModifierInteractor.ownerId=id
        MoveInteractor.ownerId=id
        MoveTypeInteractor.ownerId=id
        PersonalityTypeInteractor.ownerId=id
        RaceInteractor.ownerId=id
        StatInteractor.ownerId=id
        ToolInteractor.ownerId=id
        WeaponInteractor.ownerId=id
    }
}