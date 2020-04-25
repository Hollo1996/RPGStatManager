package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.model.character.Stat

object StatInteractor: A_TableInteractor<Stat>() {
    override fun save(d: Stat) {
        TODO("Not yet implemented")
    }

    override fun delete(d: Stat) {
        TODO("Not yet implemented")
    }

    override fun get(): Stat {
        TODO("Not yet implemented")
    }

    override fun getWhen(filter: (Stat) -> Boolean): Stat {
        TODO("Not yet implemented")
    }

    override fun list(): List<Stat> {
        TODO("Not yet implemented")
    }

    override fun listWhen(pattern: (Stat) -> Boolean): List<Stat> {
        TODO("Not yet implemented")
    }
}