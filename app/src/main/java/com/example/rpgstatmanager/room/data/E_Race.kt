package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName= "race",
    foreignKeys = [ForeignKey(
        entity = E_Character::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("characterId"),
        onDelete = ForeignKey.CASCADE
    )
    ])
data class E_Race (
    @PrimaryKey(autoGenerate= true)
    var id: String,
    @ColumnInfo(name = "characterId")
    var characterId: String,
    @ColumnInfo(name = "categoryName")
    var categoryName: String,
    @ColumnInfo(name = "familyName")
    var familyName: String,
    @ColumnInfo(name = "raceName")
    var raceName: String,
    @ColumnInfo(name = "subraceName")
    var subraceName: String
)