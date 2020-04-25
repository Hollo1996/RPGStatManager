package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.MoveInteractor
import com.example.rpgstatmanager.interactor.data.character.RaceInteractor
import com.example.rpgstatmanager.interactor.data.character.ToolInteractor
import com.example.rpgstatmanager.interactor.data.character.WeaponInteractor
import com.example.rpgstatmanager.model.character.Move
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.AllMovesScreen

object AllMovesPresenter  : A_Presenter<AllMovesScreen>(){
    fun list() = MoveInteractor.list()
}