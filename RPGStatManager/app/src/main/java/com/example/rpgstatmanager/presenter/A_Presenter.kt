package com.example.rpgstatmanager.presenter

abstract class A_Presenter<S> {
    protected var screen: S? = null
    open fun attachScreen(screen: S) {
        this.screen= screen
    }

    open fun detachScreen() {
        this.screen= null
    }
}