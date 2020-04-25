package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.RaceInteractor
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.RaceScreen

object RacePresenter : A_Presenter<RaceScreen>() {
    fun get() =  RaceInteractor.get()
    fun set(name:String) = RaceInteractor.getWhen { it.subRaceName.compareTo(name) == 0 }
}