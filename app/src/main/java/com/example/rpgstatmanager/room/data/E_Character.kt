package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "character",
    foreignKeys = [ForeignKey(
        entity = E_Adventure::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("adventureId"),
        onDelete = ForeignKey.CASCADE
    )
    ]
)
data class E_Character(
    @PrimaryKey(autoGenerate = true)
    var id: String,
    @ColumnInfo(name = "adventureId")
    var adventureId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "isNpc")
    var isNpc: Boolean
)