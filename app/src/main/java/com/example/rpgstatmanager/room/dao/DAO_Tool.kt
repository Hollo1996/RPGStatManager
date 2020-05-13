package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_Tool
import com.example.rpgstatmanager.room.data.E_ToolMoveConnector

interface DAO_Tool{
    @Query("SELECT * FROM row_item_tool")
    fun listAllTools(): List<E_Tool>
    @Query("SELECT * FROM row_item_tool WHERE id = :id")
    fun getToolsById(id: String): List<E_Tool>
    @Query("SELECT * FROM row_item_tool WHERE characterId = :characterId")
    fun listToolsOfCharacter(characterId: String): List<E_Tool>
    @Insert
    fun insertTools(vararg tool: E_Tool)
    @Update
    fun updateTools(vararg tool: E_Tool)
    @Delete
    fun deleteTool(tool: E_Tool)
}