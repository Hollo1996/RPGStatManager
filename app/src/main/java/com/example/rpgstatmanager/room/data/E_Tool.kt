package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName= "row_item_tool",
    foreignKeys = [ForeignKey(
        entity = E_Character::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("characterId"),
        onDelete = ForeignKey.CASCADE
    )
    ])
data class E_Tool (
    @PrimaryKey(autoGenerate= true)
    var id: String,
    @ColumnInfo(name = "characterId")
    var characterId: String,
    @ColumnInfo(name = "name")
    var name: String,
    var moves: List<E_Move> = ArrayList()
)