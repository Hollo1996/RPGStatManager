package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_Weapon

interface DAO_Weapon{
    @Query("SELECT * FROM row_item_weapon")
    fun listAllWeapons(): List<E_Weapon>
    @Query("SELECT * FROM row_item_weapon WHERE id = :id")
    fun getWeaponsById(id: String): List<E_Weapon>
    @Query("SELECT * FROM row_item_weapon WHERE characterId = :characterId")
    fun listWeaponsOfCharacter(characterId: String): List<E_Weapon>
    @Insert
    fun insertWeapons(vararg weapon: E_Weapon)
    @Update
    fun updateWeapons(vararg weapon: E_Weapon)
    @Delete
    fun deleteWeapon(weapon: E_Weapon)
}