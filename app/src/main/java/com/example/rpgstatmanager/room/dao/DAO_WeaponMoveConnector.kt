package com.example.rpgstatmanager.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rpgstatmanager.room.data.E_WeaponMoveConnector

interface DAO_WeaponMoveConnector{
    @Query("SELECT * FROM weaponMoveConnector")
    fun listAllWeaponMoveConnectors(): List<E_WeaponMoveConnector>
    @Query("SELECT * FROM weaponMoveConnector WHERE weaponId = :row_item_weapon")
    fun listWeaponMoveConnectorsOfWeapon(weapon: String): List<E_WeaponMoveConnector>
    @Query("SELECT * FROM weaponMoveConnector WHERE moveId = :move")
    fun listWeaponMoveConnectorsOfMove(move: String): List<E_WeaponMoveConnector>
    @Query("SELECT * FROM weaponMoveConnector WHERE id = :id")
    fun getWeaponMoveConnectorsById(id: String): List<E_WeaponMoveConnector>
    @Insert
    fun insertWeaponMoveConnectors(vararg weaponMoveConnector: E_WeaponMoveConnector)
    @Update
    fun updateWeaponMoveConnectors(vararg weaponMoveConnector: E_WeaponMoveConnector)
    @Delete
    fun deleteWeaponMoveConnector(weaponMoveConnector: E_WeaponMoveConnector)
}