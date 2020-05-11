package com.example.rpgstatmanager.interactor.data

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.interactor.data.character.*
import com.example.rpgstatmanager.model.D_Character
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.S_Character
import javax.inject.Inject

class CharacterInteractor @Inject constructor(
    private val dataApi: DataApi,
    private val raceInteractor: RaceInteractor,
    private val emotionModifierInteractor: EmotionModifierInteractor,
    private val moveTypeInteractor: MoveTypeInteractor,
    private val personalityTypeInteractor: PersonalityTypeInteractor,
    private val statInteractor: StatInteractor,
    private val toolInteractor: ToolInteractor,
    private val weaponInteractor: WeaponInteractor

) : A_TableInteractor<D_Character>() {
    override fun save(d: D_Character, exists: Boolean) {
        if (exists) {
            dataApi.updateCharacter(
                AuthInteractor.actualToken,
                S_Character(d.id, d.name, false)
            ).execute()
        } else {
            dataApi.createCharacter(
                AuthInteractor.actualToken,
                S_Character(d.id, d.name, d.is_npc)
            ).execute()
        }
    }

    override fun delete(d: D_Character) {
        dataApi.deleteCharacter(AuthInteractor.actualToken, d.id).execute()
    }

    override fun list(): List<D_Character> {
        val data: List<S_Character>
        val call = dataApi.listCharacters(AuthInteractor.actualToken, PathTracker.adventure)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map {
            D_Character(
                it.id ?: throw Error("Id must not be null"),
                it.name ?: throw Error("Id must not be null"),
                raceInteractor.get(),
                emotionModifierInteractor.list(),
                moveTypeInteractor.list(),
                personalityTypeInteractor.get(),
                statInteractor.list(),
                toolInteractor.list(),
                weaponInteractor.list(),
                it.isNpc ?: throw Error("")
            )
        }
    }


}