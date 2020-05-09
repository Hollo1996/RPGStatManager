package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName= "emotionModifier",
    foreignKeys = [ForeignKey(
        entity = E_Character::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("characterId"),
        onDelete = ForeignKey.CASCADE
    )
    ])
data class E_EmotionModifier (
    @PrimaryKey(autoGenerate= true)
    var id: String,
    @ColumnInfo(name = "characterId")
    var characterId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "trigger")
    var trigger: String,
    var values: List<E_KeyValue> = ArrayList()
)