package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.MoveInteractor
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.AllMovesScreen
import javax.inject.Inject

class AllMovesPresenter
@Inject constructor(
    private val moveInteractor: MoveInteractor
)
    : A_Presenter<AllMovesScreen>(){
    fun list() = moveInteractor.list()
}