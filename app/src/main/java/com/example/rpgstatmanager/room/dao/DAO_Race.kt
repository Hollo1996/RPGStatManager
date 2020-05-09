package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_Race

interface DAO_Race{
    @Query("SELECT * FROM race")
    fun listAllRaces(): List<E_Race>
    @Query("SELECT * FROM race WHERE id = :id")
    fun getRacesById(id: String): List<E_Race>
    @Query("SELECT * FROM race WHERE characterId = :characterId")
    fun listRacesOfCharacter(characterId: String): List<E_Race>
    @Insert
    fun insertRaces(vararg race: E_Race)
    @Update
    fun updateRaces(vararg race: E_Race)
    @Delete
    fun deleteRace(race: E_Race)
}