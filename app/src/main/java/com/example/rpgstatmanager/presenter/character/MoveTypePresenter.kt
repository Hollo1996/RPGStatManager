package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.MoveTypeInteractor
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.MoveTypeScreen
import javax.inject.Inject

class MoveTypePresenter
@Inject constructor(
    private val moveTypeInteractor: MoveTypeInteractor
)
    : A_Presenter<MoveTypeScreen>() {
    fun list() = moveTypeInteractor.list()
}