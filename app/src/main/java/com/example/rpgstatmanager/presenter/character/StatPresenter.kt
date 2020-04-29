package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.StatInteractor
import com.example.rpgstatmanager.model.character.D_Stat
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.StatScreen
import javax.inject.Inject

class StatPresenter
@Inject constructor(
    private val statInteractor: StatInteractor
)
    : A_Presenter<StatScreen>() {
    fun list()=statInteractor.list()
    fun save(DStat:D_Stat)= statInteractor.save(DStat,true)
}