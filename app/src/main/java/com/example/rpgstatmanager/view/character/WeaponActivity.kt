package com.example.rpgstatmanager.view.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.presenter.character.WeaponPresenter
import com.example.rpgstatmanager.screen.character.WeaponScreen
import javax.inject.Inject

class WeaponActivity : AppCompatActivity(),WeaponScreen {

    @Inject
    lateinit var presenter : WeaponPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon)
    }

    override fun onStart() {
        super.onStart()
        //injector.inject(this)
        presenter.attachScreen(this)
    }
    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }
}
