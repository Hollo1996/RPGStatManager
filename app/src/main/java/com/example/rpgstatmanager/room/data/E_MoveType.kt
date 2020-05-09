package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rpgstatmanager.swagger.client.model.MoveType
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@Entity(tableName= "moveType")
data class E_MoveType (
    @PrimaryKey(autoGenerate= true)
    var id: String?,
    @ColumnInfo(name = "characterId")
    var characterId: String,
    @ColumnInfo(name = "half")
    var half: String,
    @ColumnInfo(name = "line")
    var line: String,
    @ColumnInfo(name = "stat1")
    var stat1: String,
    @ColumnInfo(name = "stat2")
    var stat2: String,
    @ColumnInfo(name = "value")
    var value: Long
)