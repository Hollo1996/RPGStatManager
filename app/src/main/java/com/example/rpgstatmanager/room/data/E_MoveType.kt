package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName= "moveType",
    foreignKeys = [ForeignKey(
        entity = E_Character::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("characterId"),
        onDelete = ForeignKey.CASCADE
    )
    ])
data class E_MoveType (
    @PrimaryKey(autoGenerate= true)
    var id: String?,
    @ColumnInfo(name = "characterId")
    var characterId: String,
    @ColumnInfo(name = "half")
    var half: String,
    @ColumnInfo(name = "line")
    var line: String,
    @ColumnInfo(name = "stat1")
    var stat1: String,
    @ColumnInfo(name = "stat2")
    var stat2: String,
    @ColumnInfo(name = "value")
    var value: Long
)