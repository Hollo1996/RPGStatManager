package com.example.rpgstatmanager.interactor.data.character

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Race
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.S_Race
import javax.inject.Inject

class RaceInteractor @Inject constructor(
    private val dataApi: DataApi,
    private val abilityInteractor: AbilityInteractor
) :
    A_TableInteractor<D_Race>() {
    override fun save(d: D_Race, exists: Boolean) {
        if (exists) {
            dataApi.updateRace(
                AuthInteractor.actualToken,
                S_Race(
                    d.id,
                    d.cathegoryName,
                    d.familyName,
                    d.raceName,
                    d.subRaceName
                )
            ).execute()
        } else {
            dataApi.createRace(
                AuthInteractor.actualToken,
                S_Race(
                    d.id,
                    d.cathegoryName,
                    d.familyName,
                    d.raceName,
                    d.subRaceName
                )
            ).execute()
        }
    }

    override fun delete(d: D_Race) {
        dataApi.deleteRace(AuthInteractor.actualToken, d.id).execute()
    }

    override fun list(): List<D_Race> {
        val data: List<S_Race>
        val call = dataApi.listRaces(AuthInteractor.actualToken, PathTracker.character)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map { race ->
            D_Race(
                race.id ?: throw Error(""),
                race.categoryName ?: throw Error(""),
                race.familyName ?: throw Error(""),
                race.raceName ?: throw Error(""),
                race.subraceName ?: throw Error(""),
                abilityInteractor.list()
            )
        }
    }
}