package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_Ability
import com.example.rpgstatmanager.room.data.E_Character

interface DAO_Character {
    @Query("SELECT * FROM character")
    fun listAllGrades(): List<E_Character>
    @Query("SELECT * FROM character WHERE adventureId = :adventureId")
    fun getCharactersByAdventure(adventureId: String): List<E_Character>
    @Insert
    fun insertCharacters(vararg character: E_Character)
    @Update
    fun updateCharacters(vararg character: E_Character)
    @Delete
    fun deleteCharacter(character: E_Character)
}