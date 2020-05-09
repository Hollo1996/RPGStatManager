package com.example.rpgstatmanager.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rpgstatmanager.swagger.client.model.EmotionModifier
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@Entity(tableName= "emotionModifier")
data class E_EmotionModifier (
    @PrimaryKey(autoGenerate= true)
    var id: String,
    @ColumnInfo(name = "characterId")
    var characterId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "trigger")
    var trigger: String,
    var values: List<E_KeyValue> = ArrayList()
)