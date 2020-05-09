package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "race")
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