package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_EmotionModifier

interface DAO_EmotionModifier {
    @Query("SELECT * FROM emotionModifier")
    fun listAllEmotionModifiers(): List<E_EmotionModifier>
    @Query("SELECT * FROM emotionModifier WHERE id = :id")
    fun getEmotionModifiersById(id: String): List<E_EmotionModifier>
    @Insert
    fun insertEmotionModifiers(vararg emotionModifier: E_EmotionModifier)
    @Update
    fun updateEmotionModifiers(vararg emotionModifier: E_EmotionModifier)
    @Delete
    fun deleteEmotionModifier(emotionModifier: E_EmotionModifier)
}