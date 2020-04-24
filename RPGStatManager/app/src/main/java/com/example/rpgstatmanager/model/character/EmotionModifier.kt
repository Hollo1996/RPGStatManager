package com.example.rpgstatmanager.model.character

data class EmotionModifier (
    val name: String,
    val modifiers: Map<String,Int>,
    val trigger: String
)