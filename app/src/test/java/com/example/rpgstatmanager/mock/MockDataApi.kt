package com.example.rpgstatmanager.mock

import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.interactor.data.CharacterInteractor
import com.example.rpgstatmanager.room.data.*
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.api.TokenApi
import com.example.rpgstatmanager.swagger.client.model.*
import retrofit2.Call
import javax.inject.Inject
import kotlin.random.Random

class MockDataApi : DataApi {

    val abilities = mutableMapOf<String, E_Ability>()
    val abilitieMCs = mutableMapOf<String, E_AbilityMoveConnector>()
    val adventures = mutableMapOf<String, E_Adventure>()
    val characters = mutableMapOf<String, E_Character>()
    val emotionModifiers = mutableMapOf<String, E_EmotionModifier>()
    val keyValues = mutableMapOf<String, E_KeyValue>()
    val moves = mutableMapOf<String, E_Move>()
    val moveTypes = mutableMapOf<String, E_MoveType>()
    val personalityTypes = mutableMapOf<String, E_PersonalityType>()
    val races = mutableMapOf<String, E_Race>()
    val stats = mutableMapOf<String, E_Stat>()
    val tools = mutableMapOf<String, E_Tool>()
    val toolMC = mutableMapOf<String, E_ToolMoveConnector>()
    val weapons = mutableMapOf<String, E_Weapon>()
    val weaponMC = mutableMapOf<String, E_WeaponMoveConnector>()

    override fun listAbilities(token: String?, body: S_Race?) =
        MockCall(abilities.values
            .filter {
                if (body == null || token == null) throw Error("Null information")
                it.raceId.compareTo(body.id) == 0
            }
            .map {
                S_Ability(it.id ?: "", it.raceId, it.name, it.positive)
            })

    override fun updateAbility(token: String?, body: S_Ability?): Call<Void> {
        if (body != null) {
            abilities[body.id] =
                E_Ability(
                    body.id,
                    body.raceId ?: "",
                    body.name ?: "",
                    body.positive,
                    body.description ?: "",
                    body.effect ?: "",
                    listOf()
                )
            body.moves.forEach {
                val amcId = Random.nextLong()
                updateMove(token, it)
            }
        }
        return VoidCall()
    }

    override fun createAbility(token: String?, body: S_Ability?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteAbility(token: String?, body: String?): Call<Void> {
        abilities.remove(body)
        return VoidCall()
    }

    override fun listAdventures(token: String?, body: S_Adventure?) =
        MockCall(adventures.values
            .filter {
                it.ownerId.compareTo(
                    MockTokenApi.activeTokens.toList().first {
                        it.second.compareTo(token ?: throw Error("Null token")) == 0
                    }.first.id
                ) == 0
            }
            .map {
                S_Adventure(it.id ?: "", it.name, it.isGm)
            }
        )

    override fun updateAdventure(token: String?, body: S_Adventure?): Call<Void> {
        if (body != null) {
            adventures[body.id] =
                E_Adventure(
                    body.id,
                    MockTokenApi.activeTokens
                        .filter {
                            it.value.compareTo(token ?: "") == 0
                        }.keys.first().id,
                    body.name ?: "",
                    body.isGm?:false,
                    body.icon ?:""
                )
        }
        return VoidCall()
    }

    override fun createAdventure(token: String?, body: S_Adventure?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteAdventure(token: String?, body: String?): Call<Void> {
        adventures.remove(body)
        return VoidCall()
    }

    override fun listCharacters(token: String?, body: S_Adventure?) = MockCall(characters.values
        .filter {
            if (body == null || token == null) throw Error("Null information")
            it.adventureId.compareTo(body.id) == 0
        }
        .map {
            S_Character(it.id, it.adventureId, it.name, it.isNpc)
        }
    )

    override fun updateCharacter(token: String?, body: S_Character?): Call<Void> {
        TODO("Not yet implemented")
        TODO("Not yet implemented")
        TODO("Not yet implemented")
        TODO("Not yet implemented")
    }

    override fun createCharacter(token: String?, body: S_Character?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteCharacter(token: String?, body: String?): Call<Void> {
        characters.remove(body)
        return VoidCall()
    }

    override fun listEmotionModifiers(
        token: String?,
        body: S_Character?
    ) = MockCall(emotionModifiers.values
        .filter {
            if (body == null || token == null) throw Error("Null information")
            it.characterId.compareTo(body.id) == 0
        }
        .map {
            S_EmotionModifier(it.id, it.name, it.trigger,
                keyValues.values
                    .filter { kv ->
                        kv.emotionModifierId.compareTo(it.id) == 0
                    }
                    .map { kv ->
                        S_KeyValue(kv.id, kv.value)
                    }
            )
        }
    )

    override fun updateEmotionModifier(token: String?, body: S_EmotionModifier?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun createEmotionModifier(token: String?, body: S_EmotionModifier?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteEmotionModifier(token: String?, body: String?): Call<Void> {
        emotionModifiers.remove(body)
        return VoidCall()
    }

    override fun listMoves(token: String?, body: S_Character?) = MockCall(moves.values
        .filter {
            val r = races.values.first { it.characterId.compareTo(body?.id ?: "") == 0 }
            val a = abilities.values.filter { it.raceId.compareTo(r.id) == 0 }
            val amc =
                abilitieMCs.values.filter { a.any { ita -> ita.id?.compareTo(it.abilityId) == 0 } }
            val t = tools.values.filter { it.characterId.compareTo(body?.id ?: "") == 0 }
            val tmc = toolMC.values.filter { t.any { itt -> itt.id.compareTo(it.toolId) == 0 } }
            val w = weapons.values.filter { it.characterId.compareTo(body?.id ?: "") == 0 }
            val wmc = weaponMC.values.filter { w.any { itw -> itw.id.compareTo(it.weaponId) == 0 } }
            amc.any { itamc -> itamc.moveId.compareTo(it.id ?: "") == 0 }
                    || tmc.any { itamc -> itamc.moveId.compareTo(it.id ?: "") == 0 }
                    || wmc.any { itamc -> itamc.moveId.compareTo(it.id ?: "") == 0 }
        }
        .map {
            S_Move(
                it.id ?: "",
                it.moveTypeId,
                it.name,
                it.cardRestriction,
                it.description,
                it.effect
            )
        }
    )

    override fun updateMove(token: String?, body: S_Move?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun createMove(token: String?, body: S_Move?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteMove(token: String?, body: String?): Call<Void> {
        moves.remove(body)
        return VoidCall()
    }

    override fun listMoveTypes(token: String?, body: S_Character?) = MockCall(moveTypes.values
        .filter { it.characterId.compareTo(body?.id ?: "") == 0 }
        .map { S_MoveType(it.id ?: "", it.half, it.line, it.stat1, it.stat2, it.value) }
    )

    override fun updateMoveType(token: String?, body: S_MoveType?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun createMoveType(token: String?, body: S_MoveType?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteMoveType(token: String?, body: String?): Call<Void> {
        moveTypes.remove(body)
        return VoidCall()
    }

    override fun listPersonalityType(
        token: String?,
        body: S_Character?
    ) = MockCall(personalityTypes.values
        .filter { it.characterId.compareTo(body?.id ?: "") == 0 }
        .map {
            S_PersonalityType(
                it.id ?: "",
                it.introvert, it.extrovert,
                it.observant, it.intuitive,
                it.thinking, it.feeling,
                it.judging, it.prospecting,
                it.assertive, it.turbulent
            )
        }
    )

    override fun updatePersonalityType(token: String?, body: S_PersonalityType?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun createPersonalityType(token: String?, body: S_PersonalityType?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deletePersonalityType(token: String?, body: String?): Call<Void> {
        personalityTypes.remove(body)
        return VoidCall()
    }

    override fun listRaces(token: String?, body: S_Character?) = MockCall(races.values
        .filter { it.characterId.compareTo(body?.id ?: "") == 0 }
        .map {
            S_Race(
                it.id ?: "",
                it.categoryName,
                it.familyName,
                it.raceName,
                it.subraceName
            )
        }
    )

    override fun updateRace(token: String?, body: S_Race?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun createRace(token: String?, body: S_Race?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteRace(token: String?, body: String?): Call<Void> {
        races.remove(body)
        return VoidCall()
    }

    override fun listStat(token: String?, body: S_Character?) = MockCall(stats.values
        .filter { it.characterId.compareTo(body?.id ?: "") == 0 }
        .map { S_Stat(it.id ?: "", it.half, it.line, it.value) }
    )

    override fun updateStat(token: String?, body: S_Stat?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun createStat(token: String?, body: S_Stat?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteStat(token: String?, body: String?): Call<Void> {
        stats.remove(body)
        return VoidCall()
    }

    override fun listTool(token: String?, body: S_Character?) = MockCall(tools.values
        .filter { it.characterId.compareTo(body?.id ?: "") == 0 }
        .map { t ->
            S_Tool(t.id ?: "", t.name, moves.values
                .filter { m ->
                    toolMC.values
                        .filter { mc -> mc.toolId.compareTo(t.id) == 0 }
                        .any { mc -> mc.moveId.compareTo(m.id ?: "") == 0 }
                }
                .map {
                    S_Move(
                        it.id ?: "",
                        it.moveTypeId,
                        it.name,
                        it.cardRestriction,
                        it.description,
                        it.effect
                    )
                }

            )
        }
    )

    override fun updateTool(token: String?, body: S_Tool?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun createTool(token: String?, body: S_Tool?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteTool(token: String?, body: String?): Call<Void> {
        tools.remove(body)
        return VoidCall()
    }


    override fun listWeapon(token: String?, body: S_Character?) = MockCall(weapons.values
        .filter { it.characterId.compareTo(body?.id ?: "") == 0 }
        .map { w ->
            S_Weapon(w.id ?: "", w.name, moves.values
                .filter { m ->
                    weaponMC.values
                        .filter { mc -> mc.weaponId.compareTo(w.id) == 0 }
                        .any { mc -> mc.moveId.compareTo(m.id ?: "") == 0 }
                }
                .map {
                    S_Move(
                        it.id ?: "",
                        it.moveTypeId,
                        it.name,
                        it.cardRestriction,
                        it.description,
                        it.effect
                    )
                }

            )
        }
    )

    override fun updateWeapon(token: String?, body: S_Weapon?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun createWeapon(token: String?, body: S_Weapon?): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteWeapon(token: String?, body: String?): Call<Void> {
        weapons.remove(body)
        return VoidCall()
    }

}