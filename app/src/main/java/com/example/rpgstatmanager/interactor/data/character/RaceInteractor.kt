package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.model.character.Race

class RaceInteractor: A_TableInteractor<Race>() {
    override fun save(d: Race) {
        TODO("Not yet implemented")
    }

    override fun delete(d: Race) {
        TODO("Not yet implemented")
    }

    override fun get(): Race {
        TODO("Not yet implemented")
    }

    override fun getWhen(filter: (Race) -> Boolean): Race {
        TODO("Not yet implemented")
    }

    override fun list(): List<Race> {
        TODO("Not yet implemented")
    }

    override fun listWhen(pattern: (Race) -> Boolean): List<Race> {
        TODO("Not yet implemented")
    }
}