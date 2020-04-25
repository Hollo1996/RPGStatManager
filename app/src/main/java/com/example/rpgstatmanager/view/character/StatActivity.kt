package com.example.rpgstatmanager.view.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.presenter.AdventureChooserPresenter
import com.example.rpgstatmanager.presenter.character.StatPresenter
import com.example.rpgstatmanager.screen.character.StatScreen

class StatActivity : AppCompatActivity(), StatScreen {
    val  presenter = StatPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stat)
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
