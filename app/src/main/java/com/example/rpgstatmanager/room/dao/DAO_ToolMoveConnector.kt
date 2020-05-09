package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_ToolMoveConnector

interface DAO_ToolMoveConnector{
    @Query("SELECT * FROM toolMoveConnector")
    fun listAllToolMoveConnectors(): List<E_ToolMoveConnector>
    @Query("SELECT * FROM toolMoveConnector WHERE toolId = :tool")
    fun listToolMoveConnectorsOfTool(tool: String): List<E_ToolMoveConnector>
    @Query("SELECT * FROM toolMoveConnector WHERE moveId = :move")
    fun listToolMoveConnectorsOfMove(move: String): List<E_ToolMoveConnector>
    @Query("SELECT * FROM toolMoveConnector WHERE id = :id")
    fun getToolMoveConnectorsById(id: String): List<E_ToolMoveConnector>
    @Insert
    fun insertToolMoveConnectors(vararg toolMoveConnector: E_ToolMoveConnector)
    @Update
    fun updateToolMoveConnectors(vararg toolMoveConnector: E_ToolMoveConnector)
    @Delete
    fun deleteToolMoveConnector(toolMoveConnector: E_ToolMoveConnector)
}