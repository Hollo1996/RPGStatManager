package com.example.rpgstatmanager.module

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.rpgstatmanager.RPGStatManagerApplication
import com.example.rpgstatmanager.RPGStatManagerApplicationComponent

val Activity.injector: RPGStatManagerApplicationComponent
    get() {
        return (this.applicationContext as RPGStatManagerApplication).injector
    }

val Fragment.injector: RPGStatManagerApplicationComponent
    get() {
        return (this.context!!.applicationContext as RPGStatManagerApplication).injector
    }