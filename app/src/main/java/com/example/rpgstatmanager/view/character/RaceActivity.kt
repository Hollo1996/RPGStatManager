package com.example.rpgstatmanager.view.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.presenter.AdventureChooserPresenter
import com.example.rpgstatmanager.presenter.character.RacePresenter
import com.example.rpgstatmanager.screen.character.RaceScreen

class RaceActivity : AppCompatActivity(), RaceScreen {
    val  presenter = RacePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_race)
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
