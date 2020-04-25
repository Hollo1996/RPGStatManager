package com.example.rpgstatmanager.interactor.data

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.model.Adventure

object AdventureInteractor: A_TableInteractor<Adventure>() {
    override fun save(d: Adventure) {
        TODO("Not yet implemented")
    }

    override fun delete(d: Adventure) {
        TODO("Not yet implemented")
    }

    override fun get(): Adventure {
        TODO("Not yet implemented")
    }

    override fun getWhen(filter: (Adventure) -> Boolean): Adventure {
        TODO("Not yet implemented")
    }

    override fun list(): List<Adventure> {
        TODO("Not yet implemented")
    }

    override fun listWhen(pattern: (Adventure) -> Boolean): List<Adventure> {
        TODO("Not yet implemented")
    }
}