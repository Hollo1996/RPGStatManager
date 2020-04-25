package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.ToolInteractor
import com.example.rpgstatmanager.model.character.Tool
import com.example.rpgstatmanager.model.character.Weapon
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.ToolScreen

object ToolPresenter : A_Presenter<ToolScreen>() {
    fun list() = ToolInteractor.list()
    fun remove(tool: Tool) = ToolInteractor.delete(tool)
    fun add(tool: Tool) = ToolInteractor.save(tool)
}