package com.example.rpgstatmanager.interactor.data.character

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Ability
import com.example.rpgstatmanager.model.character.D_Move
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.Ability
import com.example.rpgstatmanager.swagger.client.model.Move
import javax.inject.Inject


class AbilityInteractor @Inject constructor(
    private val dataApi: DataApi
) : A_TableInteractor<D_Ability>() {
    override fun save(d: D_Ability, exists: Boolean) {
        if (exists) {
            dataApi.updateAbility(
                AuthInteractor.actualToken,
                Ability(
                    d.id,
                    PathTracker.race.id,
                    d.name,
                    d.positive,
                    d.description,
                    d.effect,
                    d.moves.map { move ->
                        Move(
                            move.id,
                            move.moveTypeId,
                            move.name,
                            move.cardRestriction,
                            move.description,
                            move.effect
                        )
                    }
                )
            ).execute()
        } else {
            dataApi.createAbility(
                AuthInteractor.actualToken,
                Ability(
                    d.id,
                    PathTracker.race.id,
                    d.name,
                    d.positive,
                    d.description,
                    d.effect,
                    d.moves.map { move ->
                        Move(
                            move.id,
                            move.moveTypeId,
                            move.name,
                            move.cardRestriction,
                            move.description,
                            move.effect
                        )
                    }
                )
            ).execute()
        }
    }

    override fun delete(d: D_Ability) {
        dataApi.deleteAbility(AuthInteractor.actualToken, d.id).execute()}

    override fun list(): List<D_Ability> {
        val data: List<Ability>
        val call = dataApi.listAbilities(AuthInteractor.actualToken, PathTracker.race)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map { ability ->
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
                            move.moveTypeId ?: throw Error(""),
                            move.name ?: throw Error(""),
                            move.cardRestriction ?: throw Error(""),
                            move.description ?: throw Error(""),
                            move.effect ?: throw Error("")
                        )
                    } ?: throw Error("")
            )
        }
    }
}