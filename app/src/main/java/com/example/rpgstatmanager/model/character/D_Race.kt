package com.example.rpgstatmanager.model.character

data class D_Race (
    val id:String,
    val cathegoryName:String,
    val familyName:String,
    val raceName:String,
    val subRaceName:String,
    val DAbilities: List<D_Ability>
)