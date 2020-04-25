package com.example.rpgstatmanager.module

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.rpgstatmanager.module.RPGStatManagerApplicationComponent

val Activity.injector: RPGStatManagerApplicationComponent
    get() {
        return (this.applicationContext as RPGStatManagerApplication).injector
    }

val Fragment.injector: RPGStatManagerApplicationComponent
    get() {
        return (this.context!!.applicationContext as RPGStatManagerApplication).injector
    }