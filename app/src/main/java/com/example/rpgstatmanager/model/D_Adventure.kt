package com.example.rpgstatmanager.model

data class D_Adventure (
    val id:String,
    val gameCharacters: List<D_Character>,
    var name: String,
    val is_gm: Boolean,
    val icon: String
) {

}