package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.StatInteractor
import com.example.rpgstatmanager.model.character.Stat
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.StatScreen

object StatPresenter : A_Presenter<StatScreen>() {
    fun list()=StatInteractor.list()
    fun save(stat:Stat)= StatInteractor.save(stat)
}