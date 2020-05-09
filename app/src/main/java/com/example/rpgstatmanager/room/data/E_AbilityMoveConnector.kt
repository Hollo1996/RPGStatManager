package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "abilityMoveConnector")
data class E_AbilityMoveConnector (
    @PrimaryKey(autoGenerate= true)
    val id : String,
    @ColumnInfo(name = "abilityId")
    val abilityId : String,
    @ColumnInfo(name = "moveId")
    val moveId : String
)