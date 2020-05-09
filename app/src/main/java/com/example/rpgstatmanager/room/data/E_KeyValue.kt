package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "keyValue")
data class E_KeyValue (
    @PrimaryKey(autoGenerate= true)
    var id: String,
    @ColumnInfo(name = "emotionModifierId")
    var emotionModifierId : String,
    @ColumnInfo(name = "value")
    var value: Long
)