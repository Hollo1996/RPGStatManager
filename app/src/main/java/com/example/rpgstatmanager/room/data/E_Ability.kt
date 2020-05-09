package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rpgstatmanager.swagger.client.model.Ability
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@Entity(tableName= "ability")
data class E_Ability (
    @PrimaryKey(autoGenerate= true)
    var id: String?,
    @ColumnInfo(name = "raceId")
    var raceId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "positive")
    var positive: Boolean?,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "effect")
    var effect: String,
    var moves: List<E_Move> = ArrayList()
)