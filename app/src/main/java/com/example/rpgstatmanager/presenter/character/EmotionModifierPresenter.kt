package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.EmotionModifierInteractor
import com.example.rpgstatmanager.interactor.data.character.MoveTypeInteractor
import com.example.rpgstatmanager.model.character.D_MoveType
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.EmotionModifierScreen
import javax.inject.Inject

class EmotionModifierPresenter
@Inject constructor(
    private val emotionModifierInteractor: EmotionModifierInteractor,
    private val moveTypeInteractor: MoveTypeInteractor
)
    : A_Presenter<EmotionModifierScreen>() {
    fun list() = emotionModifierInteractor.list()
    fun turnOn(emotion:String){
        val modifiers = list()
        val modifier = modifiers.filter { it.name == emotion }[0]

        val moveTypes = moveTypeInteractor.list()
        for (moveType in moveTypes){
            val newValue = D_MoveType(moveType.id, moveType.half, moveType.line, moveType.stat1, moveType.stat2,
                moveType.value
                        + ( modifier.modifiers[moveType.stat1] ?:throw Error("No stat modifier found by the given stat name") )
                        + ( modifier.modifiers[moveType.stat2] ?:throw Error("No stat modifier found by the given stat name") )
            )
            moveTypeInteractor.save(newValue,true)
        }
    }
    fun turnOff(emotion:String){
        val modifiers = list()
        val modifier = modifiers.filter { it.name == emotion }[0]

        val moveTypes = moveTypeInteractor.list()
        for (moveType in moveTypes){
            val newValue = D_MoveType(moveType.id, moveType.half, moveType.line, moveType.stat1, moveType.stat2,
                moveType.value
                        - ( modifier.modifiers[moveType.stat1] ?:throw Error("No stat modifier found by the given stat name") )
                        - ( modifier.modifiers[moveType.stat2] ?:throw Error("No stat modifier found by the given stat name") )
            )
            moveTypeInteractor.save(newValue,true)
        }
    }
}