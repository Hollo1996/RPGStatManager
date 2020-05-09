package com.example.rpgstatmanager.interactor.data.character

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_MoveType
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.S_MoveType
import javax.inject.Inject

class MoveTypeInteractor @Inject constructor(
    private val dataApi: DataApi
) : A_TableInteractor<D_MoveType>() {
    override fun save(d: D_MoveType, exists: Boolean) {
        if (exists) {
            dataApi.updateMoveType(
                AuthInteractor.actualToken,
                S_MoveType(d.id, d.half, d.line, d.stat1, d.stat2, d.value.toLong())
            ).execute()
        } else {
            dataApi.createMoveType(
                AuthInteractor.actualToken,
                S_MoveType(d.id, d.half, d.line, d.stat1, d.stat2, d.value.toLong())
            ).execute()
        }
    }

    override fun delete(d: D_MoveType) {
        dataApi.deleteMoveType(AuthInteractor.actualToken, d.id).execute()
    }

    override fun list(): List<D_MoveType> {
        val data: List<S_MoveType>
        val call = dataApi.listMoveTypes(AuthInteractor.actualToken, PathTracker.character)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map { moveType ->
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
}