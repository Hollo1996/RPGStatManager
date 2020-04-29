package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_MoveType
import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import com.example.rpgstatmanager.swagger.client.models.MoveType
import com.example.rpgstatmanager.swagger.client.models.PersonalityType
import javax.inject.Inject

class MoveTypeInteractor @Inject constructor(
    private val dataApi: DataApi
) : A_TableInteractor<D_MoveType>() {
    override fun save(d: D_MoveType, exists: Boolean)  =
        if(exists){
            dataApi.updateMoveType(
                AuthInteractor.actualToken,
                MoveType(d.id,d.half,d.line,d.stat1,d.stat2,d.value.toLong())
            )
        }
        else{
            dataApi.createMoveType(
                AuthInteractor.actualToken,
                MoveType(d.id,d.half,d.line,d.stat1,d.stat2,d.value.toLong())
            )
        }

    override fun delete(d: D_MoveType) = dataApi.deleteMoveType(AuthInteractor.actualToken, d.id)

    override fun list() =
        dataApi.listMoveTypes(AuthInteractor.actualToken, PathTracker.character)
        .map { moveType ->
            D_MoveType(
                moveType.id ?: throw Error(),
                moveType.half ?: throw Error(),
                moveType.line ?: throw Error(),
                moveType.stat1 ?: throw Error(),
                moveType.stat2 ?: throw Error(),
                moveType.value?.toInt() ?: throw Error()
            )
        }
}