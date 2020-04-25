package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.model.character.Weapon

object WeaponInteractor: A_TableInteractor<Weapon>() {
    override fun save(d: Weapon) {
        TODO("Not yet implemented")
    }

    override fun delete(d: Weapon) {
        TODO("Not yet implemented")
    }

    override fun get(): Weapon {
        TODO("Not yet implemented")
    }

    override fun getWhen(filter: (Weapon) -> Boolean): Weapon {
        TODO("Not yet implemented")
    }

    override fun list(): List<Weapon> {
        TODO("Not yet implemented")
    }

    override fun listWhen(pattern: (Weapon) -> Boolean): List<Weapon> {
        TODO("Not yet implemented")
    }
}