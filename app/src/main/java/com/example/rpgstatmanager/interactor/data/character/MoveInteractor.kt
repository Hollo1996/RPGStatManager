package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.model.character.Move

class MoveInteractor: A_TableInteractor<Move>() {
    override fun save(d: Move) {
        TODO("Not yet implemented")
    }

    override fun delete(d: Move) {
        TODO("Not yet implemented")
    }

    override fun get(): Move {
        TODO("Not yet implemented")
    }

    override fun getWhen(filter: (Move) -> Boolean): Move {
        TODO("Not yet implemented")
    }

    override fun list(): List<Move> {
        TODO("Not yet implemented")
    }

    override fun listWhen(pattern: (Move) -> Boolean): List<Move> {
        TODO("Not yet implemented")
    }
}