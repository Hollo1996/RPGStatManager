package com.example.rpgstatmanager.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rpgstatmanager.room.dao.*
import com.example.rpgstatmanager.room.data.*

@Database(
    entities = [
        E_Ability::class,
        E_AbilityMoveConnector::class,
        E_Adventure::class,
        E_Character::class,
        E_EmotionModifier::class,
        E_KeyValue::class,
        E_Move::class,
        E_MoveType::class,
        E_PersonalityType::class,
        E_Race::class,
        E_Stat::class,
        E_Tool::class,
        E_ToolMoveConnector::class,
        E_Weapon::class,
        E_WeaponMoveConnector::class
    ], version = 1
)
abstract class RPGDataBase : RoomDatabase() {

    abstract fun abilityDao(): DAO_Ability
    abstract fun abilityMoveConnectorDao(): DAO_AbilityMoveConnector
    abstract fun adventureDao(): DAO_Adventure
    abstract fun characterDao(): DAO_Character
    abstract fun emotionModifierDao(): DAO_EmotionModifier
    abstract fun keyValueDao(): DAO_KeyValue
    abstract fun moveDao(): DAO_Move
    abstract fun moveTypeDao(): DAO_MoveType
    abstract fun personalityTypeDao(): DAO_PersionalityType
    abstract fun raceDao(): DAO_Race
    abstract fun statDao(): DAO_Stat
    abstract fun toolDao(): DAO_Tool
    abstract fun toolMoveConnectorDao(): DAO_ToolMoveConnector
    abstract fun weaponDao(): DAO_Weapon
    abstract fun weaponMoveConnectorDao(): DAO_WeaponMoveConnector

    companion object {
        private var INSTANCE: RPGDataBase? = null
        fun getInstance(context: Context): RPGDataBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    RPGDataBase::class.java,
                    "rpg.db"
                ).build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}