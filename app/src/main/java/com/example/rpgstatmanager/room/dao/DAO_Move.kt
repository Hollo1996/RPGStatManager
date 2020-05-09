package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_Move

interface DAO_Move {
    @Query("SELECT * FROM move")
    fun listAllMoves(): List<E_Move>
    @Query("SELECT * FROM move WHERE moveTypeId = :moveType")
    fun listMovesOfMoveType(moveType: String): List<E_Move>
    @Query("SELECT * FROM move WHERE id = :id")
    fun getMovesById(id: String): List<E_Move>
    @Insert
    fun insertMoves(vararg move: E_Move)
    @Update
    fun updateMoves(vararg move: E_Move)
    @Delete
    fun deleteMove(move: E_Move)
}