package com.example.rpgstatmanager.interactor

abstract class A_TableInteractor<D> {
    abstract fun save(d: D)
    abstract fun delete(d: D)
    abstract fun get(): D
    abstract fun getWhen(pattern: String): D
    abstract fun list(): List<D>
    abstract fun listWhen(pattern: String): List<D>
}