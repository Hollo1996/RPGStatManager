package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "weaponMoveConnector")
data class E_WeaponMoveConnector (
    @PrimaryKey(autoGenerate= true)
    val id : String,
    @ColumnInfo(name = "weaponId")
    val weaponId : String,
    @ColumnInfo(name = "moveId")
    val moveId : String
)