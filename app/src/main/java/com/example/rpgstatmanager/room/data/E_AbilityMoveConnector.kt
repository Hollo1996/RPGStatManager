package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName= "abilityMoveConnector",
    foreignKeys = [ForeignKey(
        entity = E_Ability::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("abilityId"),
        onDelete = ForeignKey.CASCADE
    ),ForeignKey(
        entity = E_Move::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("moveId"),
        onDelete = ForeignKey.CASCADE
    )])
data class E_AbilityMoveConnector (
    @PrimaryKey(autoGenerate= true)
    val id : String,
    @ColumnInfo(name = "abilityId")
    val abilityId : String,
    @ColumnInfo(name = "moveId")
    val moveId : String
)