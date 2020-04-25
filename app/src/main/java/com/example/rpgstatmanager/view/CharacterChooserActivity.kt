package com.example.rpgstatmanager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.presenter.AdventureChooserPresenter
import com.example.rpgstatmanager.presenter.CharacterChooserPresenter
import com.example.rpgstatmanager.screen.CharacterChooserScreen

class CharacterChooserActivity : AppCompatActivity(), CharacterChooserScreen {

    val  presenter = CharacterChooserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
