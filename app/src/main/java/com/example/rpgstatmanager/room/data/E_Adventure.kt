package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "adventure")
data class E_Adventure (
    @PrimaryKey(autoGenerate= true)
    var id: String?,
    @ColumnInfo(name = "ownerId")
    var ownerId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "isGm")
    var isGm: Boolean,
    @ColumnInfo(name = "icon")
    var icon: String
)