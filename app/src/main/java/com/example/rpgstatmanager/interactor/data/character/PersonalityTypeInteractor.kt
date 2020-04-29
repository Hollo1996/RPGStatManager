package com.example.rpgstatmanager.interactor.data.character

import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_PersonalityType
import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import com.example.rpgstatmanager.swagger.client.models.PersonalityType
import com.example.rpgstatmanager.swagger.client.models.Race
import javax.inject.Inject

class PersonalityTypeInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_PersonalityType>() {

    override fun save(d: D_PersonalityType, exists: Boolean)  =
        if(exists){
            dataApi.updatePersonalityType(
                AuthInteractor.actualToken,
                PersonalityType(
                    d.id,
                    d.introvert.toLong(),
                    d.extrovert.toLong(),
                    d.observent.toLong(),
                    d.intuitive.toLong(),
                    d.thinking.toLong(),
                    d.feeling.toLong(),
                    d.judging.toLong(),
                    d.prospecting.toLong(),
                    d.assertive.toLong(),
                    d.turbulent.toLong()
                )
            )
        }
        else{
            dataApi.createPersonalityType(
                AuthInteractor.actualToken,
                PersonalityType(
                    d.id,
                    d.introvert.toLong(),
                    d.extrovert.toLong(),
                    d.observent.toLong(),
                    d.intuitive.toLong(),
                    d.thinking.toLong(),
                    d.feeling.toLong(),
                    d.judging.toLong(),
                    d.prospecting.toLong(),
                    d.assertive.toLong(),
                    d.turbulent.toLong()
                )
            )
        }

    override fun delete(d: D_PersonalityType) = dataApi.deletePersonalityType(AuthInteractor.actualToken, d.id)

    override fun list() =
        dataApi.listPersonalityType(AuthInteractor.actualToken, PathTracker.character)
            .map{ personalityType ->
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
        }
}