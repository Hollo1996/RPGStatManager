package com.example.rpgstatmanager.interactor.data.character

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Stat
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.S_Stat
import javax.inject.Inject

class StatInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_Stat>() {
    override fun save(d: D_Stat, exists: Boolean) {
        if (exists) {
            dataApi.updateStat(
                AuthInteractor.actualToken,
                S_Stat(d.id, d.half, d.line, d.value.toLong())
            ).execute()
        } else {
            dataApi.createStat(
                AuthInteractor.actualToken,
                S_Stat(d.id, d.half, d.line, d.value.toLong())
            ).execute()
        }
    }

    override fun delete(d: D_Stat) {
        dataApi.deleteStat(AuthInteractor.actualToken, d.id).execute()
    }

    override fun list(): List<D_Stat> {
        val data: List<S_Stat>
        val call = dataApi.listStat(AuthInteractor.actualToken, PathTracker.character)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map { stat ->
            D_Stat(
                stat.id ?: throw Error(),
                stat.half ?: throw Error(),
                stat.line ?: throw Error(),
                stat.value?.toInt() ?: throw Error()
            )
        }
    }
}