package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_KeyValue

interface DAO_KeyValue {
    @Query("SELECT * FROM keyValue")
    fun listAllKeyValues(): List<E_KeyValue>
    @Query("SELECT * FROM keyValue WHERE id = :id")
    fun getKeyValuesById(id: String): List<E_KeyValue>
    @Query("SELECT * FROM keyValue WHERE emotionModifierId = :emotionModifierId")
    fun listKeyValuesOfEmotionModifier(emotionModifierId: String): List<E_KeyValue>
    @Insert
    fun insertKeyValues(vararg keyValue: E_KeyValue)
    @Update
    fun updateKeyValues(vararg keyValue: E_KeyValue)
    @Delete
    fun deleteKeyValue(keyValue: E_KeyValue)
}