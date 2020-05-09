package com.example.rpgstatmanager.room.data

import androidx.room.*
import java.util.*

@Entity(
    tableName = "ability",
    foreignKeys = [ForeignKey(
        entity = E_Race::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("raceId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class E_Ability(
    @PrimaryKey(autoGenerate = true)
    var id: String?,
    @ColumnInfo(name = "raceId")
    var raceId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "positive")
    var positive: Boolean?,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "effect")
    var effect: String,
    var moves: List<E_Move> = ArrayList()
)