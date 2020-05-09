package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rpgstatmanager.swagger.client.model.Adventure
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@Entity(tableName= "adventure")
data class E_Adventure (
    @PrimaryKey(autoGenerate= true)
    var id: String?,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "isGm")
    var isGm: Boolean,
    @ColumnInfo(name = "icon")
    var icon: String
)