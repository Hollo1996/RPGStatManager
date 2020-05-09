package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName= "keyValue",
    foreignKeys = [ForeignKey(
        entity = E_EmotionModifier::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("emotionModifierId"),
        onDelete = ForeignKey.CASCADE
    )
    ])
data class E_KeyValue (
    @PrimaryKey(autoGenerate= true)
    var id: String,
    @ColumnInfo(name = "emotionModifierId")
    var emotionModifierId : String,
    @ColumnInfo(name = "value")
    var value: Long
)