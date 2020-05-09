package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName= "personalityType",
    foreignKeys = [ForeignKey(
        entity = E_Character::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("characterId"),
        onDelete = ForeignKey.CASCADE
    )
    ])
data class E_PersonalityType (
    @PrimaryKey(autoGenerate= true)
    var id: String? = null,
    @ColumnInfo(name = "characterId")
    var characterId: String,
    @ColumnInfo(name = "introvert")
    var introvert: Long,
    @ColumnInfo(name = "extrovert")
    var extrovert: Long,
    @ColumnInfo(name = "observant")
    var observant: Long,
    @ColumnInfo(name = "intuitive")
    var intuitive: Long,
    @ColumnInfo(name = "thinking")
    var thinking: Long,
    @ColumnInfo(name = "feeling")
    var feeling: Long,
    @ColumnInfo(name = "judging")
    var judging: Long,
    @ColumnInfo(name = "prospecting")
    var prospecting: Long,
    @ColumnInfo(name = "assertive")
    var assertive: Long,
    @ColumnInfo(name = "turbulent")
    var turbulent: Long
)