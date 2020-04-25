package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.MoveTypeInteractor
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.MoveTypeScreen

object MoveTypePresenter : A_Presenter<MoveTypeScreen>() {
    fun list() = MoveTypeInteractor.list()
}