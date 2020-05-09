package com.example.rpgstatmanager.interactor.data.character

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Move
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.Move
import javax.inject.Inject

class MoveInteractor @Inject constructor(
    private val dataApi: DataApi
) : A_TableInteractor<D_Move>() {
    override fun save(d: D_Move, exists: Boolean) {
        if (exists) {
            dataApi.updateMove(
                AuthInteractor.actualToken,
                Move(d.id, d.moveTypeId, d.name, d.cardRestriction, d.description, d.effect)
            ).execute()
        } else {
            dataApi.createMove(
                AuthInteractor.actualToken,
                Move(d.id, d.moveTypeId, d.name, d.cardRestriction, d.description, d.effect)
            ).execute()
        }
    }

    override fun delete(d: D_Move) {
        dataApi.deleteMove(AuthInteractor.actualToken, d.id).execute()
    }

    override fun list(): List<D_Move> {
        val data: List<Move>
        val call = dataApi.listMoves(AuthInteractor.actualToken, PathTracker.character)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map {
            D_Move(
                it.id ?: throw Error(),
                it.moveTypeId ?: throw Error(),
                it.name ?: throw Error(),
                it.cardRestriction ?: throw Error(),
                it.description ?: throw Error(),
                it.effect ?: throw Error()
            )
        }
    }
}