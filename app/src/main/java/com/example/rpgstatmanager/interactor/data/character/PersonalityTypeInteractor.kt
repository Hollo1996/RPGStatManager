package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.model.character.PersonalityType

object PersonalityTypeInteractor: A_TableInteractor<PersonalityType>() {
    override fun save(d: PersonalityType) {
        TODO("Not yet implemented")
    }

    override fun delete(d: PersonalityType) {
        TODO("Not yet implemented")
    }

    override fun get(): PersonalityType {
        TODO("Not yet implemented")
    }

    override fun getWhen(filter: (PersonalityType) -> Boolean): PersonalityType {
        TODO("Not yet implemented")
    }

    override fun list(): List<PersonalityType> {
        TODO("Not yet implemented")
    }

    override fun listWhen(pattern: (PersonalityType) -> Boolean): List<PersonalityType> {
        TODO("Not yet implemented")
    }
}