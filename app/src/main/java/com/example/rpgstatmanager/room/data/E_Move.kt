package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "move")
data class E_Move (
    @PrimaryKey(autoGenerate= true)
    var id: String?,
    @ColumnInfo(name = "moveTypeId")
    var moveTypeId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "cardRestriction")
    var cardRestriction: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "effect")
    var effect: String
)