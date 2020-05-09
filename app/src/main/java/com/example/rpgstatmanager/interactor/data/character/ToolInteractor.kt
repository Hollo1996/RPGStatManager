package com.example.rpgstatmanager.interactor.data.character

import android.util.Log
import com.example.rpgstatmanager.interactor.A_TableInteractor
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.model.character.D_Move
import com.example.rpgstatmanager.model.character.D_Tool
import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.model.S_Move
import com.example.rpgstatmanager.swagger.client.model.S_Tool
import javax.inject.Inject

class ToolInteractor @Inject constructor(
    private val dataApi: DataApi
) :
    A_TableInteractor<D_Tool>() {
    override fun save(d: D_Tool, exists: Boolean) {
        if (exists) {
            dataApi.updateTool(
                AuthInteractor.actualToken,
                S_Tool(
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
            dataApi.createTool(
                AuthInteractor.actualToken,
                S_Tool(
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

    override fun delete(d: D_Tool) {
        dataApi.deleteTool(AuthInteractor.actualToken, d.id).execute()
    }

    override fun list(): List<D_Tool> {
        val data: List<S_Tool>
        val call = dataApi.listTool(AuthInteractor.actualToken, PathTracker.character)
        val response = call.execute()
        Log.d("Reponse", response.body().toString())
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        data = response.body()

        return data.map { tool ->
            D_Tool(
                tool.id ?: throw Error(),
                tool.name ?: throw Error(),
                tool.moves
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