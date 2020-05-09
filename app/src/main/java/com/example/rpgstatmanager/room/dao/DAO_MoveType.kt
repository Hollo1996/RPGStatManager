package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_MoveType

interface DAO_MoveType {
    @Query("SELECT * FROM moveType")
    fun listAllMoveTypes(): List<E_MoveType>
    @Query("SELECT * FROM moveType WHERE id = :id")
    fun getMoveTypesById(id: String): List<E_MoveType>
    @Query("SELECT * FROM moveType WHERE characterId = :characterId")
    fun listMoveTypesOfCharacter(characterId: String): List<E_MoveType>
    @Insert
    fun insertMoveTypes(vararg moveType: E_MoveType)
    @Update
    fun updateMoveTypes(vararg moveType: E_MoveType)
    @Delete
    fun deleteMoveType(moveType: E_MoveType)
}