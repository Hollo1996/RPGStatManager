package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Move
import com.example.rpgstatmanager.model.character.D_Weapon
import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import com.example.rpgstatmanager.swagger.client.models.Adventure
import com.example.rpgstatmanager.swagger.client.models.Move
import com.example.rpgstatmanager.swagger.client.models.Weapon
import javax.inject.Inject

class WeaponInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_Weapon>() {
    override fun save(d: D_Weapon, exists: Boolean)  =
        if(exists){
            dataApi.updateWeapon(
                AuthInteractor.actualToken,
                Weapon(
                    d.id,
                    d.name,
                    d.DMoves.map {move->
                            Move(
                                move.id,
                                move.moveTypeId,
                                move.name,
                                move.cardRestriction,
                                move.description,
                                move.effect
                            )
                        }.toTypedArray()
                )
            )
        }
        else{
            dataApi.createWeapon(
                AuthInteractor.actualToken,
                Weapon(
                    d.id,
                    d.name,
                    d.DMoves.map {move->
                        Move(
                            move.id,
                            move.moveTypeId,
                            move.name,
                            move.cardRestriction,
                            move.description,
                            move.effect
                        )
                    }.toTypedArray()
                )
            )
        }

    override fun delete(d: D_Weapon) = dataApi.deleteWeapon(AuthInteractor.actualToken,d.id)

    override fun list() =
        dataApi.listWeapon(AuthInteractor.actualToken, PathTracker.character)
            .map { tool ->
                D_Weapon(
                    tool.id ?: throw Error(),
                    tool.name ?: throw Error(),
                    tool.moves
                        ?.map { move ->
                            D_Move(
                                move.id ?: throw Error(""),
                                move.move_type_id ?: throw Error(""),
                                move.name ?: throw Error(""),
                                move.cardRestriction ?: throw Error(""),
                                move.description ?: throw Error(""),
                                move.effect ?: throw Error("")
                            )
                        } ?: throw Error("")
                )
            }
}