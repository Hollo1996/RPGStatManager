package com.example.rpgstatmanager.module

import android.content.Context
import com.example.rpgstatmanager.interactor.DataBaseInteractor
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.interactor.data.CharacterInteractor
import com.example.rpgstatmanager.interactor.data.character.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideDataBaseInteractor() = DataBaseInteractor()
    @Provides
    @Singleton
    fun provideAdventureInteractor() = AdventureInteractor()
    @Provides
    @Singleton
    fun provideCharacterInteractor() = CharacterInteractor()

    @Provides
    @Singleton
    fun provideAbilityInteractor() = AbilityInteractor()
    @Provides
    @Singleton
    fun provideEmotionModifierInteractor() = EmotionModifierInteractor()
    @Provides
    @Singleton
    fun provideMoveInteractor() = MoveInteractor()
    @Provides
    @Singleton
    fun provideMoveTypeInteractor() = MoveTypeInteractor()
    @Provides
    @Singleton
    fun providePersonalityTypeInteractor() = PersonalityTypeInteractor()
    @Provides
    @Singleton
    fun provideRaceInteractor() = RaceInteractor()
    @Provides
    @Singleton
    fun provideStatInteractor() = StatInteractor()
    @Provides
    @Singleton
    fun provideToolInteractor() = ToolInteractor()
    @Provides
    @Singleton
    fun provideWeaponInteractor() = WeaponInteractor()

    @Provides
    @Singleton
    fun provideAuthInteractor() = AuthInteractor()
}