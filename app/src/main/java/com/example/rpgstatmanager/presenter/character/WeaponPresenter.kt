package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.WeaponInteractor
import com.example.rpgstatmanager.model.character.Weapon
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.WeaponScreen
import javax.inject.Inject

class WeaponPresenter
@Inject constructor(
    private val weaponInteractor: WeaponInteractor
)
    : A_Presenter<WeaponScreen>() {
    fun list() = weaponInteractor.list()
    fun remove(weapon:Weapon) = weaponInteractor.delete(weapon)
    fun add(weapon: Weapon) = weaponInteractor.save(weapon)
}