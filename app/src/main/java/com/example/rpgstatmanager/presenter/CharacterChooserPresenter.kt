package com.example.rpgstatmanager.presenter

import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.data.CharacterInteractor
import com.example.rpgstatmanager.interactor.data.character.*
import com.example.rpgstatmanager.screen.CharacterChooserScreen
import javax.inject.Inject

class CharacterChooserPresenter
@Inject constructor(
    private val characterInteractor: CharacterInteractor
) : A_Presenter<CharacterChooserScreen>() {
    fun list() = characterInteractor.list()
    fun choose(id: String) {
        val temp=characterInteractor.getWhen { it.id == id }
        PathTracker.character.id=temp.id
        PathTracker.character.isNpc=temp.is_npc
        PathTracker.character.name=temp.name
        PathTracker.race.id=temp.DRace.id
        PathTracker.race.categoryName=temp.DRace.cathegoryName
        PathTracker.race.familyName=temp.DRace.familyName
        PathTracker.race.raceName=temp.DRace.raceName
        PathTracker.race.subraceName=temp.DRace.subRaceName
    }
}