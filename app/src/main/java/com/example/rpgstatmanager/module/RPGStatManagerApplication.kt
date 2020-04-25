package com.example.rpgstatmanager.module

import android.app.Application

class RPGStatManagerApplication : Application() {
    lateinit var injector: RPGStatManagerApplicationComponent

    override fun onCreate() {
        super.onCreate()
        //injector = DaggerRPGStatManagerApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}