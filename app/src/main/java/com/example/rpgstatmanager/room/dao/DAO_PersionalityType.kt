package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_PersonalityType

interface DAO_PersionalityType{
    @Query("SELECT * FROM personalityType")
    fun listAllPersonalityTypes(): List<E_PersonalityType>
    @Query("SELECT * FROM personalityType WHERE id = :id")
    fun getPersonalityTypesById(id: String): List<E_PersonalityType>
    @Query("SELECT * FROM personalityType WHERE characterId = :characterId")
    fun listPersonalityTypesOfCharacter(characterId: String): List<E_PersonalityType>
    @Insert
    fun insertPersonalityTypes(vararg personalityType: E_PersonalityType)
    @Update
    fun updatePersonalityTypes(vararg personalityType: E_PersonalityType)
    @Delete
    fun deletePersonalityType(personalityType: E_PersonalityType)
}