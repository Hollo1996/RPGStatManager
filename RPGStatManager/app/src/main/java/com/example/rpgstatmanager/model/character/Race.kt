package com.example.rpgstatmanager.model.character

data class Race (
    val cathegoryName:String,
    val familyName:String,
    val raceName:String,
    val subRaceName:String,
    val abilities: List<Ability>,
    val moves: List<Move>
)