package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "toolMoveConnector")
data class E_ToolMoveConnector (
    @PrimaryKey(autoGenerate= true)
    val id : String,
    @ColumnInfo(name = "toolId")
    val toolId : String,
    @ColumnInfo(name = "moveId")
    val moveId : String
)