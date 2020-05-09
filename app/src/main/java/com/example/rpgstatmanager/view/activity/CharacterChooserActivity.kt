package com.example.rpgstatmanager.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.AdventureChooserPresenter
import com.example.rpgstatmanager.presenter.CharacterChooserPresenter
import com.example.rpgstatmanager.screen.CharacterChooserScreen
import javax.inject.Inject

class CharacterChooserActivity : AppCompatActivity(), CharacterChooserScreen {

    @Inject
    lateinit var presenter : CharacterChooserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_character_chooser)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }

}
