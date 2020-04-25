package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.WeaponInteractor
import com.example.rpgstatmanager.model.character.Move
import com.example.rpgstatmanager.model.character.Weapon
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.WeaponScreen

object WeaponPresenter : A_Presenter<WeaponScreen>() {
    fun list() = WeaponInteractor.list()
    fun remove(weapon:Weapon) = WeaponInteractor.delete(weapon)
    fun add(weapon: Weapon) = WeaponInteractor.save(weapon)
}