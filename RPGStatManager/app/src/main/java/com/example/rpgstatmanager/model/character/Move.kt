package com.example.rpgstatmanager.model.character

data class Move (
    val name: String,
    val type: MoveType,
    val cardRestriction: String,
    val discription: String,
    val effect: String
)