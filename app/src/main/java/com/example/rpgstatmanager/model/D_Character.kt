package com.example.rpgstatmanager.model

import com.example.rpgstatmanager.model.character.*

data class D_Character (
    val id:String,
    val adventureId:String,
    val name:String,
    val DRace: D_Race,
    val DEmotions: List<D_EmotionModifier>,
    val DMoveTypes: List<D_MoveType>,
    val personalityType: D_PersonalityType,
    val DStat: List<D_Stat>,
    val DTools: List<D_Tool>,
    val DWeapons: List<D_Weapon>,
    val is_npc: Boolean
    ) {
}