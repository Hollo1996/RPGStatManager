package com.example.rpgstatmanager.presenter

import com.example.rpgstatmanager.interactor.data.CharacterInteractor
import com.example.rpgstatmanager.interactor.data.character.*
import com.example.rpgstatmanager.screen.CharacterChooserScreen
import javax.inject.Inject

class CharacterChooserPresenter
@Inject constructor(
    private val characterInteractor: CharacterInteractor,
    private val abilityInteractor: AbilityInteractor,
    private val emotionModifierInteractor: EmotionModifierInteractor,
    private val moveInteractor: MoveInteractor,
    private val moveTypeInteractor: MoveTypeInteractor,
    private val personalityTypeInteractor: PersonalityTypeInteractor,
    private val raceInteractor: RaceInteractor,
    private val statInteractor: StatInteractor,
    private val toolInteractor: ToolInteractor,
    private val weaponInteractor: WeaponInteractor
) : A_Presenter<CharacterChooserScreen>() {
    fun list() = characterInteractor.list()
    fun choose(id: String) {
        abilityInteractor.ownerId = id
        emotionModifierInteractor.ownerId = id
        moveInteractor.ownerId = id
        moveTypeInteractor.ownerId = id
        personalityTypeInteractor.ownerId = id
        raceInteractor.ownerId = id
        statInteractor.ownerId = id
        toolInteractor.ownerId = id
        weaponInteractor.ownerId = id
    }
}