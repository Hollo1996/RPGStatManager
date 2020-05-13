package com.example.rpgstatmanager

import android.app.Application
import com.example.rpgstatmanager.mock.MockNetworkModule
import com.example.rpgstatmanager.module.InteractorModule
import com.example.rpgstatmanager.module.NetworkModule
import com.example.rpgstatmanager.module.UIModule

class RPGStatManagerApplication : Application() {
    lateinit var injector: RPGStatManagerApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerRPGStatManagerApplicationComponent.builder()
            .uIModule( UIModule() )
            .interactorModule( InteractorModule() )
            .mockNetworkModule( MockNetworkModule() )
            .build()
    }
}