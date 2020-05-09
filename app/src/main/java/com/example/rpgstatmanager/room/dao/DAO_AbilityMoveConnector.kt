package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_Ability
import com.example.rpgstatmanager.room.data.E_AbilityMoveConnector

interface DAO_AbilityMoveConnector {
    @Query("SELECT * FROM abilityMoveConnector")
    fun listAllAbilityMoveConnector(): List<E_AbilityMoveConnector>
    @Query("SELECT * FROM abilityMoveConnector WHERE abilityId = :ability")
    fun listAbilityMoveConnectorOfAbility(ability: String): List<E_AbilityMoveConnector>
    @Query("SELECT * FROM abilityMoveConnector WHERE moveId = :move")
    fun listAbilityMoveConnectorOfMove(move: String): List<E_AbilityMoveConnector>
    @Query("SELECT * FROM abilityMoveConnector WHERE id = :id")
    fun getAbilityMoveConnectorById(id: String): List<E_AbilityMoveConnector>
    @Insert
    fun insertAbilityMoveConnector(vararg connector: E_AbilityMoveConnector)
    @Update
    fun updateAbilityMoveConnector(vararg connector: E_AbilityMoveConnector)
    @Delete
    fun deleteAbilityMoveConnector(vararg connector: E_AbilityMoveConnector)
}