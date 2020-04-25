package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.model.character.Tool

object ToolInteractor: A_TableInteractor<Tool>() {
    override fun save(d: Tool) {
        TODO("Not yet implemented")
    }

    override fun delete(d: Tool) {
        TODO("Not yet implemented")
    }

    override fun get(): Tool {
        TODO("Not yet implemented")
    }

    override fun getWhen(filter: (Tool) -> Boolean): Tool {
        TODO("Not yet implemented")
    }

    override fun list(): List<Tool> {
        TODO("Not yet implemented")
    }

    override fun listWhen(pattern: (Tool) -> Boolean): List<Tool> {
        TODO("Not yet implemented")
    }
}