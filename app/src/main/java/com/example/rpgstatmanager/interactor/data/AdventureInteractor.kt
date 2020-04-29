package com.example.rpgstatmanager.interactor.data

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.D_Adventure
import com.example.rpgstatmanager.model.D_Character
import com.example.rpgstatmanager.model.character.*
import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import com.example.rpgstatmanager.swagger.client.models.Adventure
import com.example.rpgstatmanager.swagger.client.models.Character
import javax.inject.Inject

class AdventureInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_Adventure>() {
    override fun save(d: D_Adventure, exists: Boolean)  =
        if(exists){
            dataApi.updateAdventure(
                AuthInteractor.actualToken,
                Adventure(d.id, d.name, d.is_gm,d.icon)
            )
        }
        else{
            dataApi.createAdventure(
                AuthInteractor.actualToken,
                Adventure(d.id, d.name, d.is_gm,d.icon)
            )
        }

    override fun delete(d: D_Adventure) = dataApi.deleteAdventure(AuthInteractor.actualToken, d.id)

    override fun list(): List<D_Adventure> =
        dataApi.listAdventures(AuthInteractor.actualToken, PathTracker.adventure)
            .map { adventure ->
                val token = AuthInteractor.actualToken
                D_Adventure(
                    adventure.id ?: throw Error(),
                    dataApi.listCharacters(token, adventure)
                        .map {
                            D_Character(
                                it.id ?: throw Error("Id must not be null"),
                                it.name ?: throw Error("Id must not be null"),
                                dataApi.listRaces(token, it).first()
                                    .let { race ->
                                        D_Race(
                                            race.id ?: throw Error(""),
                                            race.categoryName ?: throw Error(""),
                                            race.familyName ?: throw Error(""),
                                            race.raceName ?: throw Error(""),
                                            race.subraceName ?: throw Error(""),
                                            dataApi.listAbilities(token, race)
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
                                                                    move.move_type_id ?: throw Error(""),
                                                                    move.name ?: throw Error(""),
                                                                    move.cardRestriction ?: throw Error(""),
                                                                    move.description ?: throw Error(""),
                                                                    move.effect ?: throw Error("")
                                                                )
                                                            } ?: throw Error("")
                                                    )
                                                }
                                        )
                                    },
                                dataApi.listEmotionModifiers(token, it)
                                    .map { emotionModifier ->
                                        D_EmotionModifier(
                                            emotionModifier.id ?: throw Error(),
                                            emotionModifier.name ?: throw Error(),
                                            emotionModifier.values?.let { values ->
                                                mapOf(
                                                    Pair(
                                                        values[0].key ?: throw Error(""),
                                                        values[0].value?.toInt() ?: throw Error("")
                                                    ),
                                                    Pair(
                                                        values[1].key ?: throw Error(""),
                                                        values[1].value?.toInt() ?: throw Error("")
                                                    ),
                                                    Pair(
                                                        values[2].key ?: throw Error(""),
                                                        values[2].value?.toInt() ?: throw Error("")
                                                    ),
                                                    Pair(
                                                        values[3].key ?: throw Error(""),
                                                        values[3].value?.toInt() ?: throw Error("")
                                                    ),
                                                    Pair(
                                                        values[4].key ?: throw Error(""),
                                                        values[4].value?.toInt() ?: throw Error("")
                                                    ),
                                                    Pair(
                                                        values[5].key ?: throw Error(""),
                                                        values[5].value?.toInt() ?: throw Error("")
                                                    )
                                                )
                                            } ?: throw Error("")
                                            ,
                                            emotionModifier.trigger ?: throw Error()
                                        )
                                    },
                                dataApi.listMoveTypes(token, it)
                                    .map { moveType ->
                                        D_MoveType(
                                            moveType.id ?: throw Error(),
                                            moveType.half ?: throw Error(),
                                            moveType.line ?: throw Error(),
                                            moveType.stat1 ?: throw Error(),
                                            moveType.stat2 ?: throw Error(),
                                            moveType.value?.toInt() ?: throw Error()
                                        )
                                    },
                                dataApi.listPersonalityType(token, it).first().let { personalityType ->
                                    D_PersonalityType(
                                        personalityType.id ?: throw Error(),
                                        personalityType.introvert?.toInt() ?: throw Error(),
                                        personalityType.extrovert?.toInt() ?: throw Error(),
                                        personalityType.observant?.toInt() ?: throw Error(),
                                        personalityType.intuitive?.toInt() ?: throw Error(),
                                        personalityType.thinking?.toInt() ?: throw Error(),
                                        personalityType.feeling?.toInt() ?: throw Error(),
                                        personalityType.judging?.toInt() ?: throw Error(),
                                        personalityType.prospecting?.toInt() ?: throw Error(),
                                        personalityType.assertive?.toInt() ?: throw Error(),
                                        personalityType.turbulent?.toInt() ?: throw Error()
                                    )
                                },
                                dataApi.listStat(token, it)
                                    .map { stat ->
                                        D_Stat(
                                            stat.id ?: throw Error(),
                                            stat.half ?: throw Error(),
                                            stat.line ?: throw Error(),
                                            stat.value?.toInt() ?: throw Error()
                                        )
                                    },
                                dataApi.listTool(token, it)
                                    .map { tool ->
                                        D_Tool(
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
                                    },
                                dataApi.listWeapon(token, it)
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
                                    },
                                it.is_npc ?: throw Error("")
                            )
                        },
                    adventure.name ?: throw Error(""),
                    adventure.is_gm ?: throw Error(""),
                    adventure.icon ?: throw Error("")

                )
            }

}