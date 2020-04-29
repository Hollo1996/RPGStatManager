package com.example.rpgstatmanager.model.character

data class D_Move (
    val id:String,
    val moveTypeId: String,
    val name: String,
    val cardRestriction: String,
    val description: String,
    val effect: String
)