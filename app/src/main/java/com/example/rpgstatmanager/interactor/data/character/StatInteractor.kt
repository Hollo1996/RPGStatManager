package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Stat
import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import com.example.rpgstatmanager.swagger.client.models.Adventure
import com.example.rpgstatmanager.swagger.client.models.Stat
import javax.inject.Inject

class StatInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_Stat>() {
    override fun save(d: D_Stat, exists: Boolean)  =
        if(exists){
            dataApi.updateStat(
                AuthInteractor.actualToken,
                Stat(d.id, d.half, d.line, d.value.toLong())
            )
        }
        else{
            dataApi.createStat(
                AuthInteractor.actualToken,
                Stat(d.id, d.half, d.line, d.value.toLong())
            )
        }

    override fun delete(d: D_Stat) = dataApi.deleteStat(AuthInteractor.actualToken, d.id)

    override fun list() =
        dataApi.listStat(AuthInteractor.actualToken, PathTracker.character)
            .map { stat ->
                D_Stat(
                    stat.id ?: throw Error(),
                    stat.half ?: throw Error(),
                    stat.line ?: throw Error(),
                    stat.value?.toInt() ?: throw Error()
                )
            }
}