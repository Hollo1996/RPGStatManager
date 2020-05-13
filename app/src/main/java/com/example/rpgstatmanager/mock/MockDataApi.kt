package com.example.rpgstatmanager.mock

import com.example.rpgstatmanager.room.data.*
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.*
import retrofit2.Call
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
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            abilities[id] =
                E_Ability(
                    id,
                    body.raceId ?: "",
                    body.name ?: "",
                    body.positive,
                    body.description ?: "",
                    body.effect ?: "",
                    listOf()
                )
            body.moves.forEach {
                var idMC = Random.nextLong().toString()
                while(abilitieMCs.keys.contains(idMC))
                    idMC = Random.nextLong().toString()
                var idM = Random.nextLong().toString()
                while(abilitieMCs.keys.contains(idM))
                    idM = Random.nextLong().toString()
                val amc = E_AbilityMoveConnector(idMC,id,idM)
                val amcId = Random.nextLong()
                updateMove(token, it)
            }
        }
        return VoidCall()
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
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            adventures[id] =
                E_Adventure(
                    id,
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
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            characters[id] =
                E_Character(
                    id,
                    body.adventureId,
                    body.name ?: "",
                    body.isNpc ?: false
                )
        }
        return VoidCall()
    }

    override fun createCharacter(token: String?, body: S_Character?): Call<Void> {
        if (body != null) {
            characters[body.id] =
                E_Character(
                    body.id,
                    body.adventureId,
                    body.name ?: "",
                    body.isNpc ?: false
                )
        }
        return VoidCall()
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
        if (body != null) {
            val em = emotionModifiers[body.id]
            emotionModifiers[body.id] =
                E_EmotionModifier(
                    body.id,
                    em?.characterId ?: throw Error("unknown id"),
                    body.name ?: em.name,
                    body.trigger ?: em.name,
                    listOf()
                )
            val kvl = keyValues.values.filter { kv -> kv.emotionModifierId.compareTo(body.id) == 0}
            for(i in kvl.indices){
                keyValues[kvl[i].id] =
                    E_KeyValue(
                        kvl[i].id,
                        body.values[i].key,
                        body.values[i].value ?: 0
                    )
            }
        }
        return VoidCall()
    }

    override fun createEmotionModifier(token: String?, body: S_EmotionModifier?): Call<Void> {
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            val em = emotionModifiers[id]
            emotionModifiers[id] =
                E_EmotionModifier(
                    id,
                    em?.characterId ?: throw Error("unknown id"),
                    body.name ?: em.name,
                    body.trigger ?: em.name,
                    listOf()
                )
            body.values.forEach {
                var idK = Random.nextLong().toString()
                while(abilities.keys.contains(idK))
                    idK = Random.nextLong().toString()
                keyValues[idK] =
                    E_KeyValue(
                        idK,
                        it.key,
                        it.value ?: 0
                    )
            }
        }
        return VoidCall()
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
        if (body != null) {
            moves[body.id] =
                E_Move(
                    body.id,
                    body.moveTypeId ?: "",
                    body.name ?: "",
                    body.cardRestriction ?: "",
                    body.description ?: "",
                    body.effect ?: ""

                )
        }
        return VoidCall()
    }

    override fun createMove(token: String?, body: S_Move?): Call<Void> {
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            moves[id] =
                E_Move(
                    id,
                    body.moveTypeId ?: "",
                    body.name ?: "",
                    body.cardRestriction ?: "",
                    body.description ?: "",
                    body.effect ?: ""

                )
        }
        return VoidCall()
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
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            val mt = moveTypes[body.id] ?: throw Error("Unknown id")
            moveTypes[body.id] =
                E_MoveType(
                    body.id,
                    mt.characterId,
                    body.half ?: "",
                    body.line ?: "",
                    body.stat1 ?: "",
                    body.stat2 ?: "",
                    body.value ?: 0
                )
        }
        return VoidCall()
    }

    override fun createMoveType(token: String?, body: S_MoveType?): Call<Void> {
        if (body != null) {
            val mt = moveTypes[body.id] ?: throw Error("Unknown id")
            moveTypes[body.id] =
                E_MoveType(
                    body.id,
                    mt.characterId,
                    body.half ?: "",
                    body.line ?: "",
                    body.stat1 ?: "",
                    body.stat2 ?: "",
                    body.value ?: 0
                )
        }
        return VoidCall()
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
        if (body != null) {
            val mt = personalityTypes[body.id] ?: throw Error("Unknown id")
            personalityTypes[body.id] =
                E_PersonalityType(
                    body.id,
                    mt.characterId,
                    body.introvert ?: 0,
                    body.extrovert ?: 0,
                    body.observant ?: 0,
                    body.intuitive ?: 0,
                    body.thinking ?: 0,
                    body.feeling ?: 0,
                    body.judging ?: 0,
                    body.prospecting ?: 0,
                    body.assertive ?: 0,
                    body.turbulent ?: 0
                )
        }
        return VoidCall()
    }

    override fun createPersonalityType(token: String?, body: S_PersonalityType?): Call<Void> {
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            personalityTypes[body.id] =
                E_PersonalityType(
                    id,
                    "",
                    body.introvert ?: 0,
                    body.extrovert ?: 0,
                    body.observant ?: 0,
                    body.intuitive ?: 0,
                    body.thinking ?: 0,
                    body.feeling ?: 0,
                    body.judging ?: 0,
                    body.prospecting ?: 0,
                    body.assertive ?: 0,
                    body.turbulent ?: 0
                )
        }
        return VoidCall()
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
        if (body != null) {
            val mt = races[body.id] ?: throw Error("Unknown id")
            races[body.id] =
                E_Race(
                    body.id,
                    mt.characterId,
                    body.categoryName ?: "",
                    body.familyName ?: "",
                    body.raceName ?: "",
                    body.subraceName ?: ""
                )
        }
        return VoidCall()
    }

    override fun createRace(token: String?, body: S_Race?): Call<Void> {
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            races[body.id] =
                E_Race(
                    body.id,
                    "",
                    body.categoryName ?: "",
                    body.familyName ?: "",
                    body.raceName ?: "",
                    body.subraceName ?: ""
                )
        }
        return VoidCall()
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
        if (body != null) {
            val mt = stats[body.id] ?: throw Error("Unknown id")
            stats[body.id] =
                E_Stat(
                    body.id,
                    mt.characterId,
                    body.half ?: "",
                    body.line ?: "",
                    body.value ?: 0
                )
        }
        return VoidCall()
    }

    override fun createStat(token: String?, body: S_Stat?): Call<Void> {
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            stats[body.id] =
                E_Stat(
                    id,
                    "",
                    body.half ?: "",
                    body.line ?: "",
                    body.value ?: 0
                )
        }
        return VoidCall()
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
        if (body != null) {
            tools[body.id] =
                E_Tool(
                    body.id,
                    "",
                    body.name ?: ""
                )
            body.moves.forEach {
                val amcId = Random.nextLong()
                updateMove(token, it)
            }
        }
        return VoidCall()
    }

    override fun createTool(token: String?, body: S_Tool?): Call<Void> {
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            tools[id] =
                E_Tool(
                    id,
                    "",
                    body.name ?: ""
                )
            body.moves.forEach {
                var idMC = Random.nextLong().toString()
                while(abilitieMCs.keys.contains(idMC))
                    idMC = Random.nextLong().toString()
                var idM = Random.nextLong().toString()
                while(abilitieMCs.keys.contains(idM))
                    idM = Random.nextLong().toString()
                val amc = E_AbilityMoveConnector(idMC,id,idM)
                val amcId = Random.nextLong()
                updateMove(token, it)
            }
        }
        return VoidCall()
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
        if (body != null) {
            weapons[body.id] =
                E_Weapon(
                    body.id,
                    "",
                    body.name ?: ""
                )
            body.moves.forEach {
                val amcId = Random.nextLong()
                updateMove(token, it)
            }
        }
        return VoidCall()
    }

    override fun createWeapon(token: String?, body: S_Weapon?): Call<Void> {
        if (body != null) {
            var id = Random.nextLong().toString()
            while(abilities.keys.contains(id))
                id = Random.nextLong().toString()
            weapons[id] =
                E_Weapon(
                    id,
                    "",
                    body.name ?: ""
                )
            body.moves.forEach {
                var idMC = Random.nextLong().toString()
                while(abilitieMCs.keys.contains(idMC))
                    idMC = Random.nextLong().toString()
                var idM = Random.nextLong().toString()
                while(abilitieMCs.keys.contains(idM))
                    idM = Random.nextLong().toString()
                val amc = E_AbilityMoveConnector(idMC,id,idM)
                val amcId = Random.nextLong()
                updateMove(token, it)
            }
        }
        return VoidCall()
    }

    override fun deleteWeapon(token: String?, body: String?): Call<Void> {
        weapons.remove(body)
        return VoidCall()
    }

}