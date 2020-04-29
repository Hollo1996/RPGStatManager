package com.example.rpgstatmanager.module

import android.content.Context
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.interactor.data.CharacterInteractor
import com.example.rpgstatmanager.interactor.data.character.*
import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideAdventureInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = AdventureInteractor(dataApi,tokenApi)
    @Provides
    @Singleton
    fun provideCharacterInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = CharacterInteractor(dataApi,tokenApi)

    @Provides
    @Singleton
    fun provideAbilityInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = AbilityInteractor(dataApi,tokenApi)
    @Provides
    @Singleton
    fun provideEmotionModifierInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = EmotionModifierInteractor(dataApi,tokenApi)
    @Provides
    @Singleton
    fun provideMoveInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = MoveInteractor(dataApi,tokenApi)
    @Provides
    @Singleton
    fun provideMoveTypeInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = MoveTypeInteractor(dataApi,tokenApi)
    @Provides
    @Singleton
    fun providePersonalityTypeInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = PersonalityTypeInteractor(dataApi,tokenApi)
    @Provides
    @Singleton
    fun provideRaceInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = RaceInteractor(dataApi,tokenApi)
    @Provides
    @Singleton
    fun provideStatInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = StatInteractor(dataApi,tokenApi)
    @Provides
    @Singleton
    fun provideToolInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = ToolInteractor(dataApi,tokenApi)
    @Provides
    @Singleton
    fun provideWeaponInteractor(dataApi:DataApi,tokenApi: TokenApi)
            = WeaponInteractor(dataApi,tokenApi)

    @Provides
    @Singleton
    fun provideAuthInteractor(tokenApi: TokenApi)
            = AuthInteractor(tokenApi)
}