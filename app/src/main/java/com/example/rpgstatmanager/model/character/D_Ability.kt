package com.example.rpgstatmanager.model.character

import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.swagger.client.models.Ability


data class D_Ability(
    val id: String,
    val name: String,
    val positive: Boolean,
    val description: String,
    val effect: String,
    val moves: List<D_Move>
)