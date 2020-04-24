package com.example.rpgstatmanager.model

import com.example.rpgstatmanager.model.character.*

data class Character (
    val race: Race,
    val emotions: List<EmotionModifier>,
    val moveTypes: List<MoveType>,
    val personalityType: PersonalityType,
    val stat: Stat,
    val tools: List<Tool>,
    val weapons: List<Weapon>,
    val abilities: List<Ability>
    )