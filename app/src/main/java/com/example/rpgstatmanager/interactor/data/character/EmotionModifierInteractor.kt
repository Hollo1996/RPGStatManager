package com.example.rpgstatmanager.interactor.data.character

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_EmotionModifier
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.S_EmotionModifier
import com.example.rpgstatmanager.swagger.client.model.S_KeyValue
import javax.inject.Inject

class EmotionModifierInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_EmotionModifier>() {
    override fun save(d: D_EmotionModifier, exists: Boolean) {
        if (exists) {
            dataApi.updateEmotionModifier(
                AuthInteractor.actualToken,
                S_EmotionModifier(
                    d.id, d.name, d.trigger,
                    List(6) {
                        S_KeyValue(
                            d.modifiers.keys.toList()[it],
                            d.modifiers.values.toList()[it].toLong()
                        )
                    }
                )
            ).execute()
        } else {
            dataApi.createEmotionModifier(
                AuthInteractor.actualToken,
                S_EmotionModifier(
                    d.id, d.name, d.trigger,
                    List(6) {
                        S_KeyValue(
                            d.modifiers.keys.toList()[it],
                            d.modifiers.values.toList()[it].toLong()
                        )
                    }
                )
            ).execute()
        }
    }

    override fun delete(d: D_EmotionModifier) {
        dataApi.deleteEmotionModifier(AuthInteractor.actualToken, d.id).execute()
    }

    override fun list(): List<D_EmotionModifier> {
        val data: List<S_EmotionModifier>
        val call = dataApi.listEmotionModifiers(AuthInteractor.actualToken, PathTracker.character)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map { emotionModifier ->
            D_EmotionModifier(
                emotionModifier.id,
                emotionModifier.name ?: throw Error(),
                emotionModifier.values.let { values ->
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
                }
                ,
                emotionModifier.trigger ?: throw Error()
            )
        }
    }
}