package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_Ability
import com.example.rpgstatmanager.room.data.E_Adventure

interface DAO_Adventure {
    @Query("SELECT * FROM adventure")
    fun listAllAdventures(): List<E_Adventure>
    @Query("SELECT * FROM adventure WHERE id = :adventure")
    fun getAdventureById(adventure: String): E_Adventure
    @Insert
    fun insertAdventures(vararg adventure: E_Adventure)
    @Update
    fun updateAdventures(vararg adventure: E_Adventure)
    @Delete
    fun deleteAdventure(adventure: E_Adventure)
}