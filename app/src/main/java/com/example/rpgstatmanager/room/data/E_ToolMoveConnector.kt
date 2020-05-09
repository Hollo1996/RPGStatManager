package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "toolMoveConnector",
    foreignKeys = [androidx.room.ForeignKey(
        entity = com.example.rpgstatmanager.room.data.E_Tool::class,
        parentColumns = kotlin.arrayOf("uid"),
        childColumns = kotlin.arrayOf("toolId"),
        onDelete = androidx.room.ForeignKey.CASCADE
    ), androidx.room.ForeignKey(
        entity = com.example.rpgstatmanager.room.data.E_Move::class,
        parentColumns = kotlin.arrayOf("uid"),
        childColumns = kotlin.arrayOf("moveId"),
        onDelete = androidx.room.ForeignKey.CASCADE
    )]
)
data class E_ToolMoveConnector(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    @ColumnInfo(name = "toolId")
    val toolId: String,
    @ColumnInfo(name = "moveId")
    val moveId: String
)