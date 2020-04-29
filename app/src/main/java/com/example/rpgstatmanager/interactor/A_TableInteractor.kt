package com.example.rpgstatmanager.interactor

abstract class A_TableInteractor<D> {
    var ownerId:String?=null
    abstract fun save(d: D, exists: Boolean)
    abstract fun delete(d: D)
    fun get() = list().first()
    fun getWhen(filter: (D)->Boolean ) = list().first(filter)
    abstract fun list(): List<D>
    fun listWhen(filter: (D)->Boolean ) = list().filter(filter)
}