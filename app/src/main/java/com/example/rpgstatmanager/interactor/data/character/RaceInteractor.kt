package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Ability
import com.example.rpgstatmanager.model.character.D_Move
import com.example.rpgstatmanager.model.character.D_Race
import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import com.example.rpgstatmanager.swagger.client.models.Race
import com.example.rpgstatmanager.swagger.client.models.Stat
import javax.inject.Inject

class RaceInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_Race>() {
    override fun save(d: D_Race, exists: Boolean)  =
        if(exists){
            dataApi.updateRace(
                AuthInteractor.actualToken,
                Race(
                    d.id,
                    d.cathegoryName,
                    d.familyName,
                    d.raceName,
                    d.subRaceName
                    )
            )
        }
        else{
            dataApi.createRace(
                AuthInteractor.actualToken,
                Race(
                    d.id,
                    d.cathegoryName,
                    d.familyName,
                    d.raceName,
                    d.subRaceName
                )
            )
        }

    override fun delete(d: D_Race) = dataApi.deleteRace(AuthInteractor.actualToken, d.id)

    override fun list() =
        dataApi.listRaces(AuthInteractor.actualToken, PathTracker.character)
            .map { race ->
                D_Race(
                    race.id ?: throw Error(""),
                    race.categoryName ?: throw Error(""),
                    race.familyName ?: throw Error(""),
                    race.raceName ?: throw Error(""),
                    race.subraceName ?: throw Error(""),
                    dataApi.listAbilities(AuthInteractor.actualToken, race)
                        .map { ability ->
                            D_Ability(
                                ability.id ?: throw Error(""),
                                ability.name ?: throw Error(""),
                                ability.positive ?: throw Error(""),
                                ability.description ?: throw Error(""),
                                ability.effect ?: throw Error(""),
                                ability.moves
                                    ?.map { move ->
                                        D_Move(
                                            move.id ?: throw Error(""),
                                            move.name ?: throw Error(""),
                                            move.move_type_id ?: throw Error(""),
                                            move.cardRestriction ?: throw Error(""),
                                            move.description ?: throw Error(""),
                                            move.effect ?: throw Error("")
                                        )
                                    } ?: throw Error("")
                            )
                        }
                )
            }
}