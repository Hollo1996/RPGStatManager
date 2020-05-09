package com.example.rpgstatmanager.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rpgstatmanager.room.dao.DAO_Ability
import com.example.rpgstatmanager.room.data.*

@Database(
    entities = arrayOf(
        E_Ability::class,
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
        E_Weapon::class
    ), version = 1
)
abstract class RPGDatabase : RoomDatabase() {

    abstract fun abilityDao(): DAO_Ability

    companion object {
        private var INSTANCE: RPGDatabase? = null
        fun getInstance(context: Context): RPGDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    RPGDatabase::class.java,
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