package com.example.rpgstatmanager.model.character

data class Ability(
    val id:String,
    val name: String,
    val positive: Boolean,
    val discription: String,
    val effect: String
)