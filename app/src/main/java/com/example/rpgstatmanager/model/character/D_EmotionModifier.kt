package com.example.rpgstatmanager.model.character

data class D_EmotionModifier (
    val id:String,
    val name: String,
    val modifiers: Map<String,Int>,
    val trigger: String
)