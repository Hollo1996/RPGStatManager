package com.example.rpgstatmanager.view.activity.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.character.AllMovesPresenter
import com.example.rpgstatmanager.screen.character.AllMovesScreen
import javax.inject.Inject

class AllMovesActivity : AppCompatActivity(), AllMovesScreen {

    @Inject
    lateinit var presenter : AllMovesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_all_moves)
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
