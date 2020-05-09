package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "weaponMoveConnector",
    foreignKeys = [ForeignKey(
        entity = E_Weapon::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("weaponId"),
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = E_Move::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("moveId"),
        onDelete = ForeignKey.NO_ACTION
    )]
)
data class E_WeaponMoveConnector(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    @ColumnInfo(name = "weaponId")
    val weaponId: String,
    @ColumnInfo(name = "moveId")
    val moveId: String
)