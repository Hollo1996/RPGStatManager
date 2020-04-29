package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_EmotionModifier
import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import com.example.rpgstatmanager.swagger.client.models.EmotionModifier
import com.example.rpgstatmanager.swagger.client.models.KeyValue
import com.example.rpgstatmanager.swagger.client.models.Move
import javax.inject.Inject

class EmotionModifierInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_EmotionModifier>() {
    override fun save(d: D_EmotionModifier, exists: Boolean) =
        if(exists){
            dataApi.updateEmotionModifier(
                AuthInteractor.actualToken,
                EmotionModifier(
                    d.id, d.name, d.trigger,
                    Array(6){
                        KeyValue(d.modifiers.keys.toList()[it],d.modifiers.values.toList()[it].toLong())
                    }
                )
            )
        }
        else{
            dataApi.createEmotionModifier(
                AuthInteractor.actualToken,
                EmotionModifier(
                    d.id, d.name, d.trigger,
                    Array(6){
                        KeyValue(d.modifiers.keys.toList()[it],d.modifiers.values.toList()[it].toLong())
                    }
                )
            )
        }

    override fun delete(d: D_EmotionModifier) = dataApi.deleteEmotionModifier(AuthInteractor.actualToken, d.id)

    override fun list() =
        dataApi.listEmotionModifiers(AuthInteractor.actualToken, PathTracker.character)
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
            }
}