package com.example.rpgstatmanager.module

import android.content.Context
import com.example.rpgstatmanager.interactor.api.AuthInteractor
import com.example.rpgstatmanager.interactor.data.AdventureInteractor
import com.example.rpgstatmanager.interactor.data.CharacterInteractor
import com.example.rpgstatmanager.interactor.data.character.*
import com.example.rpgstatmanager.presenter.AdventureChooserPresenter
import com.example.rpgstatmanager.presenter.AdventureCreatorPresenter
import com.example.rpgstatmanager.presenter.CharacterChooserPresenter
import com.example.rpgstatmanager.presenter.MainPresenter
import com.example.rpgstatmanager.presenter.character.*
import com.example.rpgstatmanager.presenter.login.ForgottenPasswordPresenter
import com.example.rpgstatmanager.presenter.login.LoginPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideAllMovesPresenter(moveInteractor: MoveInteractor) = AllMovesPresenter(moveInteractor)

    @Provides
    @Singleton
    fun provideEmotionModifierPresenter(
        emotionModifierInteractor: EmotionModifierInteractor,
        moveTypeInteractor: MoveTypeInteractor
    ) = EmotionModifierPresenter(
        emotionModifierInteractor,
        moveTypeInteractor
    )

    @Provides
    @Singleton
    fun provideMoveTypePresenter(
        moveTypeInteractor: MoveTypeInteractor
    ) = MoveTypePresenter(
        moveTypeInteractor
    )

    @Provides
    @Singleton
    fun providePersonalityTypePresenter(
        emotionModifierInteractor: EmotionModifierInteractor,
        emotionModifierPresenter: EmotionModifierPresenter,
        personalityTypeInteractor: PersonalityTypeInteractor
    ) = PersonalityTypePresenter(
        emotionModifierInteractor,
        emotionModifierPresenter,
        personalityTypeInteractor
    )

    @Provides
    @Singleton
    fun provideRacePresenter(
        raceInteractor: RaceInteractor
    ) = RacePresenter(
        raceInteractor
    )

    @Provides
    @Singleton
    fun provideStatPresenter(
        statInteractor: StatInteractor
    ) = StatPresenter(
        statInteractor
    )

    @Provides
    @Singleton
    fun provideToolPresenter(
        toolInteractor: ToolInteractor
    ) = ToolPresenter(
        toolInteractor
    )

    @Provides
    @Singleton
    fun provideWeaponPresenter(
        weaponInteractor: WeaponInteractor
    ) = WeaponPresenter(
        weaponInteractor
    )

    @Provides
    @Singleton
    fun provideForgottenPasswordPresenter(
        authInteractor: AuthInteractor
    ) = ForgottenPasswordPresenter(
        authInteractor
    )

    @Provides
    @Singleton
    fun provideLoginPresenter(
        authInteractor: AuthInteractor,
        adventureInteractor: AdventureInteractor
    ) = LoginPresenter(
        authInteractor,
        adventureInteractor
    )

    @Provides
    @Singleton
    fun provideAdventureCreatorPresenter(
        adventureInteractor: AdventureInteractor
    ) = AdventureCreatorPresenter(
        adventureInteractor
    )

    @Provides
    @Singleton
    fun provideAdventureChooserPresenter(
        adventureInteractor: AdventureInteractor,
        characterInteractor: CharacterInteractor
    ) = AdventureChooserPresenter(adventureInteractor,characterInteractor)

    @Provides
    @Singleton
    fun provideCharacterChooserPresenter(
        characterInteractor: CharacterInteractor,
        abilityInteractor: AbilityInteractor,
        emotionModifierInteractor: EmotionModifierInteractor,
        moveInteractor: MoveInteractor,
        moveTypeInteractor: MoveTypeInteractor,
        personalityTypeInteractor: PersonalityTypeInteractor,
        raceInteractor: RaceInteractor,
        statInteractor: StatInteractor,
        toolInteractor: ToolInteractor,
        weaponInteractor: WeaponInteractor
    ) = CharacterChooserPresenter(
        characterInteractor,
        abilityInteractor,
        emotionModifierInteractor,
        moveInteractor,
        moveTypeInteractor,
        personalityTypeInteractor,
        raceInteractor,
        statInteractor,
        toolInteractor,
        weaponInteractor
    )

    @Provides
    @Singleton
    fun provideMainPresenter() = MainPresenter()
}