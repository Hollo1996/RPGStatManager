package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.ToolInteractor
import com.example.rpgstatmanager.model.character.Tool
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.ToolScreen
import javax.inject.Inject

class ToolPresenter
@Inject constructor(
    private val toolInteractor: ToolInteractor
)
    : A_Presenter<ToolScreen>() {
    fun list() = toolInteractor.list()
    fun remove(tool: Tool) = toolInteractor.delete(tool)
    fun add(tool: Tool) = toolInteractor.save(tool)
}