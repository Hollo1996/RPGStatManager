package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "character")
data class E_Character (
    @PrimaryKey(autoGenerate= true)
    var id: String,
    @ColumnInfo(name = "adventureId")
    var adventureId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "isNpc")
    var isNpc: Boolean)