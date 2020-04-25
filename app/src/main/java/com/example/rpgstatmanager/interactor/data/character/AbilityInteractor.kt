package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.model.character.Ability

class AbilityInteractor: A_TableInteractor<Ability>() {
    override fun save(d: Ability) {
        TODO("Not yet implemented")
    }

    override fun delete(d: Ability) {
        TODO("Not yet implemented")
    }

    override fun get(): Ability {
        TODO("Not yet implemented")
    }

    override fun getWhen(filter: (Ability) -> Boolean): Ability {
        TODO("Not yet implemented")
    }

    override fun list(): List<Ability> {
        TODO("Not yet implemented")
    }

    override fun listWhen(pattern: (Ability) -> Boolean): List<Ability> {
        TODO("Not yet implemented")
    }
}