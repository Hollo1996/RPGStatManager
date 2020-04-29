package com.example.rpgstatmanager.presenter.character

import com.example.rpgstatmanager.interactor.data.character.WeaponInteractor
import com.example.rpgstatmanager.model.character.D_Weapon
import com.example.rpgstatmanager.presenter.A_Presenter
import com.example.rpgstatmanager.screen.character.WeaponScreen
import javax.inject.Inject

class WeaponPresenter
@Inject constructor(
    private val weaponInteractor: WeaponInteractor
)
    : A_Presenter<WeaponScreen>() {
    fun list() = weaponInteractor.list()
    fun remove(DWeapon:D_Weapon) = weaponInteractor.delete(DWeapon)
    fun add(DWeapon: D_Weapon) = weaponInteractor.save(DWeapon,false)
}