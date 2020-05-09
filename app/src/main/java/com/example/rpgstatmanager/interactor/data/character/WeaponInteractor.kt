package com.example.rpgstatmanager.interactor.data.character

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Move
import com.example.rpgstatmanager.model.character.D_Weapon
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.S_Move
import com.example.rpgstatmanager.swagger.client.model.S_Weapon
import javax.inject.Inject

class WeaponInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_Weapon>() {
    override fun save(d: D_Weapon, exists: Boolean) {
        if (exists) {
            dataApi.updateWeapon(
                AuthInteractor.actualToken,
                S_Weapon(
                    d.id,
                    d.name,
                    d.DMoves.map { move ->
                        S_Move(
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
            dataApi.createWeapon(
                AuthInteractor.actualToken,
                S_Weapon(
                    d.id,
                    d.name,
                    d.DMoves.map { move ->
                        S_Move(
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

    override fun delete(d: D_Weapon) {
        dataApi.deleteWeapon(AuthInteractor.actualToken, d.id)
    }

    override fun list(): List<D_Weapon> {
        val data: List<S_Weapon>
        val call = dataApi.listWeapon(AuthInteractor.actualToken, PathTracker.character)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map { weapon ->
            D_Weapon(
                weapon.id ?: throw Error(),
                weapon.name ?: throw Error(),
                weapon.moves
                    .map { move ->
                        D_Move(
                            move.id ?: throw Error(""),
                            move.moveTypeId ?: throw Error(""),
                            move.name ?: throw Error(""),
                            move.cardRestriction ?: throw Error(""),
                            move.description ?: throw Error(""),
                            move.effect ?: throw Error("")
                        )
                    }
            )
        }
    }
}