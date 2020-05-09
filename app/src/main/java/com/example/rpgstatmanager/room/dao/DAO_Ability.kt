package com.example.rpgstatmanager.room.dao


import androidx.room.*
import com.example.rpgstatmanager.room.data.E_Ability

@Dao
interface DAO_Ability {
    @Query("SELECT * FROM ability")
    fun listAllAbilities(): List<E_Ability>
    @Query("SELECT * FROM ability WHERE raceId = :raceId")
    fun listAbilitiesOfRace(raceId: String): List<E_Ability>
    @Query("SELECT * FROM ability WHERE id = :id")
    fun getAbilitiesById(id: String): List<E_Ability>
    @Insert
    fun insertAbility(vararg ability: E_Ability)
    @Update
    fun updateAbility(vararg ability: E_Ability)
    @Delete
    fun deleteAbility(ability: E_Ability)
}