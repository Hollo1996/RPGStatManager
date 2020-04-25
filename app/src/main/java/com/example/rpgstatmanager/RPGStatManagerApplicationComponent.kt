package com.example.rpgstatmanager

import com.example.rpgstatmanager.module.InteractorModule
import com.example.rpgstatmanager.module.UIModule
import com.example.rpgstatmanager.view.AdventureChooserActivity
import com.example.rpgstatmanager.view.AdventureCreatorActivity
import com.example.rpgstatmanager.view.CharacterChooserActivity
import com.example.rpgstatmanager.view.MainActivity
import com.example.rpgstatmanager.view.character.*
import com.example.rpgstatmanager.view.login.ForgottenPasswordActivity
import com.example.rpgstatmanager.view.login.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules= [UIModule::class, InteractorModule::class])
interface RPGStatManagerApplicationComponent{
    fun inject(allMovesActivity: AllMovesActivity)
    fun inject(emotionModifierActivity: EmotionModifierActivity)
    fun inject(moveTypeActivity:  MoveTypeActivity)
    fun inject(personalityTypeActivity: PersonalityTypeActivity)
    fun inject(raceActivity: RaceActivity)
    fun inject(statActivity: StatActivity)
    fun inject(toolActivity: ToolActivity)
    fun inject(weaponActivity: WeaponActivity)
    fun inject(forgottenPasswordActivity: ForgottenPasswordActivity)
    fun inject(loginActivity: LoginActivity)
    fun inject(adventureCreatorActivity: AdventureCreatorActivity)
    fun inject(adventureChooserActivity: AdventureChooserActivity)
    fun inject(characterChooserActivity: CharacterChooserActivity)
    fun inject(mainActivity: MainActivity)

}