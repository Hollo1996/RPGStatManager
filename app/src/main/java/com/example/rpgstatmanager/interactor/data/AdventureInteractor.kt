package com.example.rpgstatmanager.interactor.data

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.D_Adventure
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.S_Adventure
import javax.inject.Inject

class AdventureInteractor @Inject constructor(
    private val dataApi: DataApi,
    private val characterInteractor: CharacterInteractor
) :
    A_TableInteractor<D_Adventure>() {
    override fun save(d: D_Adventure, exists: Boolean)  {
        if(exists){
            dataApi.updateAdventure(
                AuthInteractor.actualToken,
                S_Adventure(d.id, d.name, d.is_gm,d.icon)
            ).execute()
        }
        else{
            dataApi.createAdventure(
                AuthInteractor.actualToken,
                S_Adventure(d.id, d.name, d.is_gm,d.icon)
            ).execute()
        }
    }

    override fun delete(d: D_Adventure) { dataApi.deleteAdventure(AuthInteractor.actualToken, d.id).execute()}

    override fun list(): List<D_Adventure> {
        val data: List<S_Adventure>
        val call = dataApi.listAdventures(AuthInteractor.actualToken,null)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map { adventure ->
            D_Adventure(
                adventure.id ?: throw Error(),
                characterInteractor.list(),
                adventure.name ?: throw Error(),
                adventure.isGm ?: throw Error(),
                adventure.icon ?: throw Error()
            )
        }
    }
}