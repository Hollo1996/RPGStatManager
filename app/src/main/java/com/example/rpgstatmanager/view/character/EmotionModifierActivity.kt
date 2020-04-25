package com.example.rpgstatmanager.view.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.presenter.character.EmotionModifierPresenter
import com.example.rpgstatmanager.screen.character.EmotionModifierScreen

class EmotionModifierActivity : AppCompatActivity(), EmotionModifierScreen {
    val  presenter = EmotionModifierPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotion)
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
