package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rpgstatmanager.swagger.client.model.Move
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@Entity(tableName= "move")
data class E_Move (
    @PrimaryKey(autoGenerate= true)
    var id: String?,
    @ColumnInfo(name = "moveTypeId")
    var moveTypeId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "cardRestriction")
    var cardRestriction: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "effect")
    var effect: String
)