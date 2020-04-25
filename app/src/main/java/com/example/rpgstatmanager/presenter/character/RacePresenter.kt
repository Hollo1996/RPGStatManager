package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.RaceInteractor
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.RaceScreen
import javax.inject.Inject

class RacePresenter
@Inject constructor(
    private val raceInteractor: RaceInteractor
)
    : A_Presenter<RaceScreen>() {
    fun get() =  raceInteractor.get()
    fun set(name:String) = raceInteractor.getWhen { it.subRaceName.compareTo(name) == 0 }
}