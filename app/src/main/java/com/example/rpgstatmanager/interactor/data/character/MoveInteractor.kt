package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Move
import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import com.example.rpgstatmanager.swagger.client.models.Move
import javax.inject.Inject

class MoveInteractor @Inject constructor(
    private val dataApi: DataApi
) : A_TableInteractor<D_Move>() {
    override fun save(d: D_Move, exists: Boolean) =
        if(exists){
            dataApi.updateMove(
                AuthInteractor.actualToken,
                Move(d.id,d.moveTypeId,d.name,d.cardRestriction,d.description,d.effect)
            )
        }
        else{
            dataApi.createMove(
                AuthInteractor.actualToken,
                Move(d.id,d.moveTypeId,d.name,d.cardRestriction,d.description,d.effect)
            )
        }

    override fun delete(d: D_Move) = dataApi.deleteMove(AuthInteractor.actualToken, d.id)

    override fun list() =
        dataApi.listMoves(AuthInteractor.actualToken, PathTracker.character)
            .map {
                D_Move(
                    it.id ?: throw Error(),
                    it.move_type_id ?: throw Error(),
                    it.name ?: throw Error(),
                    it.cardRestriction ?: throw Error(),
                    it.description ?: throw Error(),
                    it.effect ?: throw Error()
                )
            }
}