package com.example.rpgstatmanager.model.character



data class D_Ability(
    val id: String,
    val name: String,
    val positive: Boolean,
    val description: String,
    val effect: String,
    val moves: List<D_Move>
)