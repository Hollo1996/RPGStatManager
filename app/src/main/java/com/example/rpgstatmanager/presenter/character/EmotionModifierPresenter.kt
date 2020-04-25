package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.EmotionModifierInteractor
import com.example.rpgstatmanager.interactor.data.character.MoveTypeInteractor
import com.example.rpgstatmanager.model.character.EmotionModifier
import com.example.rpgstatmanager.model.character.MoveType
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.EmotionModifierScreen

object EmotionModifierPresenter  : A_Presenter<EmotionModifierScreen>() {
    fun list() = EmotionModifierInteractor.list()
    fun turnOn(emotion:String){
        val modifiers = list()
        val modifier = modifiers.filter { it.name == emotion }[0]

        val moveTypes = MoveTypeInteractor.list()
        for (moveType in moveTypes){
            val newValue = MoveType(moveType.id, moveType.name, moveType.half, moveType.line, moveType.stat1, moveType.stat2,
                moveType.value
                        + ( modifier.modifiers[moveType.stat1] ?:throw Error("No stat modifier found by the given stat name") )
                        + ( modifier.modifiers[moveType.stat2] ?:throw Error("No stat modifier found by the given stat name") )
            )
            MoveTypeInteractor.save(moveType)
        }
    }
    fun turnOff(emotion:String){
        val modifiers = list()
        val modifier = modifiers.filter { it.name == emotion }[0]

        val moveTypes = MoveTypeInteractor.list()
        for (moveType in moveTypes){
            val newValue = MoveType(moveType.id, moveType.name, moveType.half, moveType.line, moveType.stat1, moveType.stat2,
                moveType.value
                        - ( modifier.modifiers[moveType.stat1] ?:throw Error("No stat modifier found by the given stat name") )
                        - ( modifier.modifiers[moveType.stat2] ?:throw Error("No stat modifier found by the given stat name") )
            )
            MoveTypeInteractor.save(moveType)
        }
    }
}