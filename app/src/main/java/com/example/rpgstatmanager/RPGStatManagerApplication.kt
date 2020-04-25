package com.example.rpgstatmanager

import android.app.Application
import com.example.rpgstatmanager.module.UIModule

class RPGStatManagerApplication : Application() {
    lateinit var injector: RPGStatManagerApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerRPGStatManagerApplicationComponent.builder().uIModule(
            UIModule(
                this
            )
        ).build()
    }
}