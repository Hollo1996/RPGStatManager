package com.example.rpgstatmanager.view.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.presenter.character.MoveTypePresenter
import com.example.rpgstatmanager.screen.character.MoveTypeScreen

class MoveTypeActivity : AppCompatActivity(), MoveTypeScreen {
    val  presenter = MoveTypePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_base)
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
