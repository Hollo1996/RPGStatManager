package com.example.rpgstatmanager.interactor

abstract class A_TableInteractor<D> {
    var ownerId:String?=null
    abstract fun save(d: D)
    abstract fun delete(d: D)
    abstract fun get(): D
    abstract fun getWhen(filter: (D)->Boolean ): D
    abstract fun list(): List<D>
    abstract fun listWhen(pattern: (D)->Boolean ): List<D>
}