package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_Stat

interface DAO_Stat{
    @Query("SELECT * FROM stat")
    fun listAllStats(): List<E_Stat>
    @Query("SELECT * FROM stat WHERE id = :id")
    fun getStatsById(id: String): List<E_Stat>
    @Query("SELECT * FROM stat WHERE characterId = :characterId")
    fun listStatsOfCharacter(characterId: String): List<E_Stat>
    @Insert
    fun insertStats(vararg stat: E_Stat)
    @Update
    fun updateStats(vararg stat: E_Stat)
    @Delete
    fun deleteStat(stat: E_Stat)
}